package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class WeightedGraph<V> extends AbstractGraph<V> {
	List<PriorityQueue<WeightedEdge> > priorityQueue ;
	
	public WeightedGraph(int[][] edges, V[] vertices) {
		super(edges, vertices);
		creatQueue(edges,vertices.length);
	}

	public WeightedGraph(List<V> vertices,List<WeightedEdge>weightedEdge){
		//TODO 这里的list为什么要这样转
		super(vertices,(List)weightedEdge);
		creatQueue(weightedEdge,vertices.size());
	}
	
	public WeightedGraph(List<WeightedEdge> weightedEdge,int numOfVertices){
		super((List)weightedEdge, numOfVertices);
		creatQueue(weightedEdge, numOfVertices);
	}
	
	public WeightedGraph(int[][] edges,int numOfVertices){
		super(edges, numOfVertices);
		creatQueue(edges, numOfVertices);
	}
	
	private void creatQueue(
			List<WeightedEdge> weightedEdge, int numOfVertices) {
		priorityQueue = new ArrayList<>();
		for(int i=0;i<numOfVertices;i++)
			priorityQueue.add(new PriorityQueue<WeightedEdge>());
		for(WeightedEdge edge:weightedEdge)
			priorityQueue.get(edge.u).offer(edge);
	}

	private void creatQueue(int[][] edges, int numOfVertices) {
		priorityQueue = new ArrayList<>();
		for(int i=0;i<numOfVertices;i++)
			priorityQueue.add(new PriorityQueue<WeightedEdge>() ) ;
		for(int i=0;i<edges.length;i++){
			int u=edges[i][0];
			int v=edges[i][1];
			int weight=edges[i][2];
			priorityQueue.get(u).offer(new WeightedEdge(u, v, weight));
		}
	}
	
	public int[][] getAdjacencyMatrix(){
		int[][] adjacentMatrix = new int[getSize()][getSize()]; 
		for(int i=0;i<getSize();i++){
			for(WeightedEdge edge:priorityQueue.get(i)){
				adjacentMatrix[i][edge.v]=edge.weight;
			}
		}
		return adjacentMatrix;
	}
	
	public void printAdjacencyMatrix(){
		int[][] adjacentMatrix=getAdjacencyMatrix();
		for(int i=0;i<adjacentMatrix.length;i++){
			for(int j=0;j<adjacentMatrix.length;j++)
				//TODO 打印矩阵时使用\t可以将矩阵对齐
				System.out.print(adjacentMatrix[i][j]+"\t"); 
			System.out.println(); 	
		}
	}
	
	public void printWeightedEdge(){
		for(int i=0;i<priorityQueue.size();i++){
			System.out.println("Vertice:"+i);
			for(WeightedEdge edge:priorityQueue.get(i)){
				System.out.print(edge.v+"  "+edge.weight); 
				System.out.println(); 
			}
		}
	}
	
	public MST getMST(int index){
		List<Integer>T = new ArrayList<>();
		List<PriorityQueue<WeightedEdge>>V=deepClone(this.priorityQueue);
		T.add(index);
		int[] parent = new int[getSize()];
		for(int i=0;i<getSize();i++)
			parent[i]=-1;
		
		while(T.size()<getSize()){
			int v=-1;
			int smallestWeight=Integer.MAX_VALUE;
			for(int u:T){
				while(!V.get(u).isEmpty() && T.contains(V.get(u).peek().v))
					V.get(u).remove();
				
				if(V.get(u).isEmpty())
					continue;
				
				WeightedEdge edge = V.get(u).peek();
				if (edge.weight<smallestWeight) {
					smallestWeight=edge.weight;
					v=edge.v;
					parent[v]=u;
				}
			}
			T.add(v);
		}
		return new MST(T, parent, index);
	}

	public ShortestPathTree getShortesPath(int index){
		List<Integer>T=new ArrayList<>();
		T.add(index);
		List<PriorityQueue<WeightedEdge>>V=deepClone(this.priorityQueue);
		
		int[] cost = new int[getSize()];
		for(int i=0;i<cost.length;i++)
			cost[i]=Integer.MAX_VALUE;
		cost[index]=0;
		
		int[] parent= new int[getSize()];
		for(int i=0;i<parent.length;i++)
			parent[i]=-1;
		
		while(T.size()<getSize()){
			int smallestWeight=Integer.MAX_VALUE;
			int v=-1;
			for(int u:T){
				while(!V.get(u).isEmpty() && T.contains(V.get(u).peek().v))
					V.get(u).remove();
				if(V.get(u).isEmpty())
					continue;
				
				WeightedEdge edge=V.get(u).peek();
				int weigt=edge.weight+cost[u];
				if(weigt<smallestWeight){
					v=edge.v;
					smallestWeight=weigt;
					cost[v]=smallestWeight;
					parent[v]=u;
				}
			}
			T.add(v);
		}
		return new ShortestPathTree(T, parent, cost,index);
		
	}
	
	private List<PriorityQueue<WeightedEdge>> deepClone(
			List<PriorityQueue<WeightedEdge>> priorityQueue) {
		
		List<PriorityQueue<WeightedEdge>>V=new ArrayList<>();
		for(int i=0;i<priorityQueue.size();i++){
			PriorityQueue<WeightedEdge> queue=new PriorityQueue<>();
			for(WeightedEdge edge:priorityQueue.get(i))
				queue.add(edge);
			V.add(queue);
		}
		return V;
	}
	
	public class MST extends Tree{
		private int start;
		public MST(List<Integer> searchOrder, int[] parent,int start) {
			super(searchOrder, parent);
			this.start=start;
		}
	}
	
	public class ShortestPathTree extends Tree{
		private int[] cost;
		private int index;
		public ShortestPathTree(List<Integer> searchOrder, int[] parent,int[] cost,int index) {
			super(searchOrder, parent);
			this.index=index;
			this.cost=cost;
		}
		public int[] getCost() {
			return cost;
		}
		public void printAllPath(){
			for(int i=0;i<getSize();i++){
				System.out.println("顶点到源点的最短路径："+i+"-->"+index+"//  权重："+cost[i]);
				for(V vertice:getPath(i))
					System.out.print(vertice+"  ");
				System.out.println();
			}
		}
	}
}
