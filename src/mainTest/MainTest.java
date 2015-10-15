package mainTest;

import graph.AbstractGraph;
import graph.UnWeightedGraph;
import graph.WeightedGraph;
import graph.WeightedGraph.MST;
import graph.WeightedGraph.ShortestPathTree;
import graph.WeightedNineTail;

import java.util.Iterator;
import java.util.List;

import queue.QueueArray;
import linkList.LinkList;
import arrayList.MyArrayList;
import arrayList.MyList;
import binaryTree.BinaryTree;

public class MainTest {

	public static void main(String[] args) {
		binaryTreeTest1();
		System.out.println("**************************************************************");
		linkListTest();
		System.out.println("**************************************************************");
//		queueTest();
//		myArrayListTest();
//		binaryTreeTest1();
//		graphTest();
//		weightedTest();
		weightNineTail();
	}
	
	public static void weightNineTail(){
		WeightedNineTail weightedNineTail = new WeightedNineTail();
		ShortestPathTree spTree = (ShortestPathTree) weightedNineTail.getTree();
		spTree.printAllPath();
	}
	
	
	
	private static void weightedTest(){
		int[][] edges={
				{0,1,2},{0,3,8},
				{1,0,2},{1,2,7},{1,3,3},
				{2,1,7},{2,3,4},{2,4,5},
				{3,0,8},{3,1,3},{3,2,4},{3,4,6},
				{4,2,5},{4,3,6},
		};
		
		int[][] edge={
				{0,1,807},{0,3,1331},{0,5,2097},
				{1,0,807},{1,2,381},{1,3,1267},
				{2,1,381},{2,3,1015},{2,4,1663},{2,10,1435},
				{3,0,1331},{3,1,1267},{3,2,1015},{3,4,599},{3,5,1003},
				{4,2,1663},{4,3,599},{4,5,533},{4,7,1260},{4,8,864},{4,10,496},
				{5,0,2097},{5,3,1003},{5,4,533},{5,6,983},{5,7,787},
				{6,5,983},{6,7,214},
				{7,4,1260},{7,5,787},{7,6,214},{7,8,888},
				{8,4,864},{8,7,888},{8,9,661},{8,10,781},{8,11,810},
				{9,8,661},{9,11,1187},
				{10,2,1435},{10,4,496},{10,8,781},{10,11,239},
				{11,8,810},{11,9,1187},{11,10,239},
		};
		String[] vertices={"seattle","san","los","denver","kan","chi","bos","new","atl","mia","dall","hous"};
		WeightedGraph weightedGraph=new WeightedGraph(edge, vertices);
		weightedGraph.printAdjacencyMatrix();
		weightedGraph.printWeightedEdge();
		MST mst= weightedGraph.getMST(0);
		mst.printTree();
		ShortestPathTree sptTree = weightedGraph.getShortesPath(5);
		System.out.println();
		sptTree.printAllPath();
	}
	
	private static void graphTest(){
		int[][] edges={
				{0,1},{0,3},{0,5},
				{1,0},{1,2},{1,3},
				{2,1},{2,3},{2,4},{2,10},
				{3,0},{3,1},{3,2},{3,4},{3,5},
				{4,2},{4,3},{4,5},{4,7},{4,8},{4,10},
				{5,0},{5,3},{5,4},{5,6},{5,7},
				{6,5},{6,7},
				{7,4},{7,5},{7,6},{7,8},
				{8,4},{8,7},{8,9},{8,10},{8,11},
				{9,8},{9,11},
				{10,2},{10,4},{10,8},{10,11},
				{11,8},{11,9},{11,10},
		};
		String[] vertices={"seattle","san","los","denver","kan","chi","bos","new","atl","mia","dall","hous"};
		UnWeightedGraph<String>graph=new UnWeightedGraph<>(edges, vertices);
		graph.printAdjacencyMatrix();
		System.out.println(graph.getDegree(0));
		/*深度优先搜索遍历图*/
		//使用阾接线性表来深度优先遍历图
		AbstractGraph<String>.Tree dfsTree=graph.dfs(0);		
		System.out.println("dfs阾接线新表："); 
		for(Integer i: dfsTree.getSearchOrder())
			System.out.print(graph.getVertex(i)+"-->"); 
		//获得从指定节点到根节点的路径
		for(String str:dfsTree.getPath(9))
			System.out.println(str+"-->"); 
		System.out.println(); 
		System.out.println("dfs阾接矩阵："); 
		//使用阾接矩阵来深度优先遍历图
		AbstractGraph<String>.Tree dfsTree1=graph.dfsMatrx(0);
		for(Integer i:dfsTree1.getSearchOrder())
			System.out.print(graph.getVertex(i)+"-->"); 
		System.out.println(); 
		for(String str:dfsTree1.getPath(9))
			System.out.println(str+"-->"); 
		System.out.println("bfs阾接线性表："); 
		//bfs广度优先搜索算法遍历图
		AbstractGraph<String>.Tree bfsTree=graph.bfs(0);
		for(Integer i:bfsTree.getSearchOrder())
			System.out.print(graph.getVertex(i)+"-->"); 
		for(String str:bfsTree.getPath(9))
			System.out.println(str+"-->"); 
	}
	
	private static void binaryTreeTest1(){
		BinaryTree<Integer> tree =new BinaryTree<>();
		Integer[] temp={5,4,6,3,7};
		for(int i=0;i<temp.length;i++)
			tree.insert(temp[i]);
		System.out.println("是否为完全二叉树："+tree.isCompleteBinaryTree());
	}
	
	private static void myArrayListTest(){
		MyList<String> list=new MyArrayList<String>();
		list.add("america");
		System.out.println("(1)"+list);
		list.add(0, "canada");
		System.out.println("(2)"+list);
//		for(int i=0;i<9;i++)
//			list.add("russia");
		list.remove("russia");
		System.out.println("(3)"+list);
		list.trimToSize();
		System.out.println("(4)"+list);
	}
	
	/*
	 * 链表的主测试函数
	 */
	private static void linkListTest(){
		//创建链表对象
		LinkList list=new LinkList(9);
		//往链表中插入8个元素
		for(int i=1;i<8;i++){
			list.insertAtBegin(i);
		}
		//遍历链表元素
		list.insertAfterId(5, 0);
		String result=list.visitAllNode();
		System.out.println("在5元素后面插入0元素："+result);
	}
	
	/*
	 * 二叉树的主测试函数
	 */
	private static void binaryTreeTest(){
		//创建二叉树
	}
	
	/*
	 * 队列测试方法
	 */private static void queueTest(){
		 QueueArray queue=new QueueArray(10);
		 //如果先出队
		 if(queue.dequeue()){
			 System.out.println("出队元素："+queue.getDequeueEle());
		 }
		 //入队10个元素
		 for(int i=0;i<10;i++){
			 if(queue.enqueue(i))
				 System.out.println(i+"入队成功");;
		 }
		 //出队10个元素
		 for(int i=0;i<10;i++){
			 if (queue.dequeue()) {
				System.out.println(queue.getDequeueEle()+"出队成功");
			}
		 }
	 }
}
