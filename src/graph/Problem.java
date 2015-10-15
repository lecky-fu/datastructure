package graph;
/*list强转问题*/
import java.util.ArrayList;
import java.util.List;

public class Problem {
	public static void main(String[] args) {
		List<weightedEdge>weightEdges = new ArrayList<>();
		for(int i=0;i<10;i++)
			weightEdges.add(new weightedEdge(i, i, i));
		List<edge>edges=(List)weightEdges;
	}
}

class edge{
	private int u;
	private int v;
	
	public edge(int u, int v) {
		super();
		this.u = u;
		this.v = v;
	}
	public int getU() {
		return u;
	}
	public int getV() {
		return v;
	}
}

class weightedEdge extends edge{
	private int weight;

	public weightedEdge(int u,int v,int weight) {
		super(u,v);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}
	
}