package graph;

/*java���Գ�����ƽ���ƪ*/
public interface Graph<V> {
	/*���ͼ�ж���ĸ���*/
	int getSize();
	
	/*���ͼ�����ж��������*/
	java.util.List<V> getVertices();
	
	/*����ָ��index���Ķ���*/
	V getVertex(int index);
	
	/*��ȡָ��index��������ھ�*/
	java.util.List<Integer> getNeighbors(int index);
	
	/*����ָ������Ķ�*/
	int getDegree(int index);
	
	/*�����t�Ӿ���*/
	int[][] getAdjacencyMatrix();

	/*��ӡ�t�Ӿ���*/
	void printAdjacencyMatrix();
	
	//TODO ����һ��������Ⱥ͹��������
	AbstractGraph<V>.Tree dfs(int index);
	AbstractGraph<V>.Tree bfs(int index);
}
