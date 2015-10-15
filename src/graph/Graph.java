package graph;

/*java语言程序设计进阶篇*/
public interface Graph<V> {
	/*获得图中定点的个数*/
	int getSize();
	
	/*获得图中所有定点的链表*/
	java.util.List<V> getVertices();
	
	/*返回指定index处的顶点*/
	V getVertex(int index);
	
	/*获取指定index处顶点的邻居*/
	java.util.List<Integer> getNeighbors(int index);
	
	/*返回指定顶点的度*/
	int getDegree(int index);
	
	/*返回阾接矩阵*/
	int[][] getAdjacencyMatrix();

	/*打印阾接矩阵*/
	void printAdjacencyMatrix();
	
	//TODO 生成一个深度优先和广度优先树
	AbstractGraph<V>.Tree dfs(int index);
	AbstractGraph<V>.Tree bfs(int index);
}
