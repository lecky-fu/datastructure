package graph;

/*
 * java语言程序设计进阶篇 图 九个硬币问题 P179
 * 采用自顶向下的方式设计类和函数会比较容易
 * */
import java.util.ArrayList;
import java.util.List;

/*描述：九个硬币问题，在一个3*3矩阵中，反转任意一个格子中的硬币和其上下左右相邻硬币，求最少步数，最终翻成正面朝下。
 * 硬币正面用'H'表示，反面用'T'表示
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
					//方向为i-->v,使用节点list创建阾接线性表时，将i节点放在v下标的线性表中
					edges.add(new AbstractGraph.Edge(v,i));
				}
			}
		}
		return edges;
	}
	
	/*翻转位置index处的上下左右及其本身硬币状态，并返回其对应的编号*/
	protected  int getFlipedNode(char[] node,int index) {
		int row=index/3;
		int colunm=index%3;
		//翻转index
		flipPosition(node, row, colunm);
		//翻转上
		flipPosition(node,row-1,colunm );
		//翻转下
		flipPosition(node, row+1, colunm);
		//翻转左
		flipPosition(node, row, colunm-1);
		//翻转右
		flipPosition(node, row, colunm+1);
		return getIndex(node);
	}
	
	/*
	  *@param char[] node 输入矩阵
	  *@return 矩阵对应的编号
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
	
	//单元测试函数
	public static void main(String[] args) {
		NineTail nineTail=new NineTail();
	}
}
