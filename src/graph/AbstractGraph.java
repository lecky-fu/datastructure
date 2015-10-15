package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import queue.QueueList;

public abstract class AbstractGraph<V> implements Graph<V> {
	//顶点
	List<V> vertices;
	//阾接线性表
	List<List<Integer>> neighbors;
	
	/*根据给定的 边界数组和 顶点数组创建图类*/
	public AbstractGraph(int[][] edges,V[] vertices) {
		this.vertices=new ArrayList<>();
		for(int i=0;i<vertices.length;i++)
			this.vertices.add(vertices[i]);
		//创建阾接线性表
		neighbors=new ArrayList<>();
		creatNeighborList(edges,vertices.length);
	}
	
	/*根据给定的 边界list和 顶点list创建图类*/
	public AbstractGraph(List<V> vertices,List<Edge>edges){
		this.vertices=vertices;
		//创建阾接线性表
		neighbors=new ArrayList<>();
		createNeighborList(edges,vertices.size());
	}
	
	/*根据给定的边和顶点数，构造图*/
	@SuppressWarnings("unchecked")
	public AbstractGraph(List<Edge>edges,int numOfVertices){
		this.vertices=new ArrayList<>();
		for(int i=0;i<numOfVertices;i++)
			this.vertices.add((V)new Integer(i));
		this.neighbors=new ArrayList<>();
		createNeighborList(edges, numOfVertices);
	}
	
	public AbstractGraph(int[][] edges,int numOfVertices){
		this.vertices = new ArrayList<>();
		for(int i=0;i<numOfVertices;i++)
			this.vertices.add((V)new Integer(i));
		this.neighbors = new ArrayList<>();
		creatNeighborList(edges, numOfVertices);
	}
	
	private void createNeighborList(List<Edge> edges, int size) {
		for(int i=0;i<size;i++)
			neighbors.add(new ArrayList<Integer>());
		for(Edge edge:edges)
			//将edge.v放在u的线性表中
			neighbors.get(edge.u).add(edge.v);
	}
	
	private void creatNeighborList(int[][] edges, int length) {
		for(int i=0;i<length;i++)
			neighbors.add(new ArrayList<Integer>());
		for(int i=0;i<edges.length;i++){
			int index=edges[i][0];
			int result=edges[i][1];
			this.neighbors.get(index).add(result);
		}
	}

	@Override
	public int getSize() {
		return vertices.size();
	}
	@Override
	public List<V> getVertices() {
		return vertices;
	}
	@Override
	public V getVertex(int index) {
		return vertices.get(index);
	}
	@Override
	public List<Integer> getNeighbors(int index) {
		return neighbors.get(index);
	}
	@Override
	public int getDegree(int index) {
		return neighbors.get(index).size();
	}
	@Override
	public int[][] getAdjacencyMatrix() {
		int length=getSize();
		int[][] adjacencyMatrix=new int[length][length];
		for(int i=0;i<length;i++){
			for(int j=0;j<neighbors.get(i).size();j++){
				adjacencyMatrix[i][neighbors.get(i).get(j)]=1;
			}
		}
		return adjacencyMatrix;
	}
	@Override
	public void printAdjacencyMatrix() {
		int[][] adjacencyMatrix=getAdjacencyMatrix();
		for(int i=0;i<adjacencyMatrix.length;i++){
			for(int j=0;j<adjacencyMatrix[i].length;j++)
				System.out.print(adjacencyMatrix[i][j]+"  ");
			System.out.println();
		}
	}
	/*根据阾接线性表来执行dfs*/
	@Override
	public Tree dfs(int index) {
		List<Integer>searchOrder=new ArrayList<>();
		boolean[] isVisited=new boolean[getSize()];
		int[] parent=new int[getSize()];
		for(int i=0;i<parent.length;i++)
			parent[i]=-1;
		dfs(index, isVisited, searchOrder,parent);
		return new Tree(searchOrder,parent);
	}
	private void dfs(int index,boolean[] isVisited,List<Integer>searchOrder,int[] parent){
		searchOrder.add(index);
		isVisited[index]=true;
		for(int i:neighbors.get(index)){
			if(!isVisited[i]){
				parent[i]=index;
				dfs(i, isVisited, searchOrder,parent);
			}
		}
	}
	/*根据阾接矩阵来执行dfs（方法来自于《啊哈，算法》）*/
	public Tree dfsMatrx(int index){
		List<Integer> searchOrder=new ArrayList<>();
		boolean[] isVisited =new boolean[getSize()];
		int[][] adjacentMatix=getAdjacencyMatrix(); 
		int[] parent = new int[getSize()];
		for(int i=0;i<getSize();i++)
			parent[i]=-1;
		dfsMatrx(index,isVisited,searchOrder,adjacentMatix,parent  );
		return new Tree(searchOrder, parent);
	}
	private void dfsMatrx(int index, boolean[] isVisited,List<Integer>searchOrder,int[][] adjacentMatix,int[] parent ) {
		searchOrder.add(index);
		isVisited[index]=true;
		for(int i=0;i<getSize();i++){
			if(adjacentMatix[index][i]==1&&!isVisited[i]){
				parent[i]=index;
				isVisited[i]=true;
				dfsMatrx(i, isVisited, searchOrder, adjacentMatix,parent);
			}
		}
	}

	@Override
	public Tree bfs(int index) {
		List<Integer>searchOrder =new ArrayList<>();
		QueueList<Integer>bfsQueue=new QueueList<>();
		boolean[] isVisited = new boolean[getSize()];
		bfsQueue.enqueue(index);
		isVisited[index]=true;
		int[] parent = new int[getSize()];
		for(int i=0;i<getSize();i++)
			parent[i]=-1;
			
		while(!bfsQueue.isEmpty()){
			int temp=bfsQueue.dequeue();
			searchOrder.add(temp);
			for(Integer i:neighbors.get(temp)){
				if(!isVisited[i]){
					parent[i]=temp;
					bfsQueue.enqueue(i);
					isVisited[i]=true;
				}
			}
		}
		return new Tree(searchOrder,parent);
	}
	
	public static class Edge{
		//起点
		public int u;
		//终点
		public int v;
		public Edge(int u,int v){
			this.u=u;
			this.v=v;
		}
	}
	
	public static class WeightedEdge extends Edge implements Comparable<WeightedEdge>{
		public int weight;
		public WeightedEdge(int u, int v,int weight) {
			super(u, v);
			this.weight=weight;
		}
		@Override
		public int compareTo(WeightedEdge edge) {
			if(this.weight<edge.weight)
				return -1;
			else if(this.weight==edge.weight)
				return 0;
			else
				return 1;
		}
		
	}
	
	public class Tree{
		private List<Integer> searchOrder;
		private int[] parent;
		public Tree(List<Integer>searchOrder ){
			this.searchOrder =searchOrder;
		}
		public Tree(List<Integer> searchOrder,int[] parent){
			this.searchOrder=searchOrder;
			this.parent=parent;
		}
		
		public List<V> getPath(int index){
			List<V> path=new ArrayList<>();
			do{
				path.add(vertices.get(index));
				index=parent[index];
			}while(-1!=index);
			return path;
		}
		public List<Integer> getSearchOrder() {
			return searchOrder;
		}
		public int[] getParent(){
			return parent;
		}
		public void printTree(){
			System.out.println("edges:");
			for(int i=0;i<parent.length;i++){
				if(-1!=parent[i])
					System.out.print("("+vertices.get(parent[i])+","+vertices.get(i)+")");
			}
		}
	}
}
