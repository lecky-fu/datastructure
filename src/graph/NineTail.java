package graph;

/*
 * java���Գ�����ƽ���ƪ ͼ �Ÿ�Ӳ������ P179
 * �����Զ����µķ�ʽ�����ͺ�����Ƚ�����
 * */
import java.util.ArrayList;
import java.util.List;

/*�������Ÿ�Ӳ�����⣬��һ��3*3�����У���ת����һ�������е�Ӳ�Һ���������������Ӳ�ң������ٲ��������շ������泯�¡�
 * Ӳ��������'H'��ʾ��������'T'��ʾ
 * */
public class NineTail {
	protected  AbstractGraph<Integer>.Tree tree;
	protected static final int NUMOFVERTICES=512;
	protected static final int MATRIXSIZE=9;
	
	public NineTail(){
		List<AbstractGraph.Edge> edges=getEdges();
		UnWeightedGraph<Integer> graph=new UnWeightedGraph(edges, NUMOFVERTICES);
		this.tree=graph.bfs(NUMOFVERTICES-1);
	}
	
	public AbstractGraph<Integer>.Tree getTree() {
		return tree;
	}

	@SuppressWarnings("rawtypes")
	private List<graph.AbstractGraph.Edge> getEdges() {
		List<AbstractGraph.Edge>edges = new ArrayList<>();
		for(int i=0;i<NUMOFVERTICES;i++){
			for(int j=0;j<MATRIXSIZE;j++){
				char[] node=getNode(i);
				if('H'==node[j]){
					int v= getFlipedNode(node,j);
					//����Ϊi-->v,ʹ�ýڵ�list�����t�����Ա�ʱ����i�ڵ����v�±�����Ա���
					edges.add(new AbstractGraph.Edge(v,i));
				}
			}
		}
		return edges;
	}
	
	/*��תλ��index�����������Ҽ��䱾��Ӳ��״̬�����������Ӧ�ı��*/
	protected  int getFlipedNode(char[] node,int index) {
		int row=index/3;
		int colunm=index%3;
		//��תindex
		flipPosition(node, row, colunm);
		//��ת��
		flipPosition(node,row-1,colunm );
		//��ת��
		flipPosition(node, row+1, colunm);
		//��ת��
		flipPosition(node, row, colunm-1);
		//��ת��
		flipPosition(node, row, colunm+1);
		return getIndex(node);
	}
	
	/*
	  *@param char[] node �������
	  *@return �����Ӧ�ı��
	  */
	protected int getIndex(char[] node) {
		int result=0;
		for(int i=0;i<MATRIXSIZE;i++){
			if('T'==node[i])
				result=(int) (result+Math.pow(2, i));
		}
		return result;
	}

	private  void flipPosition(char[] node, int row, int colunm) {
		if(row>=0 && row<=2 && colunm>=0 && colunm<=2){
			int index=3*row+colunm;
			if('T'==node[index])
				node[index]='H';
			else
				node[index]='T';
		}
	}

	protected  char[] getNode(int index) {
		char[] node = new char[MATRIXSIZE];
		for(int i=0;i<MATRIXSIZE;i++){
			if(1==(index%2))
				node[i]='T';
			else
				node[i]='H';
			index=index>>1;
		}
		return node;
	}

	public  List<Integer> getShortestPath(int index){
		return tree.getPath(index);
	}
	
	public  void printNode(int index){
		for(int i:tree.getPath(index)){
			char[] node=getNode(i);
			System.out.println(i+":"); 
			for(int j=0;j<MATRIXSIZE;j++){
				System.out.print(node[j]+" "); 
				if(j%3==2)
					System.out.println(); 
			}
			System.out.println(); 
		}
	}
	
	//��Ԫ���Ժ���
	public static void main(String[] args) {
		NineTail nineTail=new NineTail();
	}
}
