package graph;

import java.util.List;

public class UnWeightedGraph<V> extends AbstractGraph<V> {

	public UnWeightedGraph(int[][] edges, V[] vertices) {
		super(edges, vertices);
	}

	public UnWeightedGraph(List<V> vertices,
			List<AbstractGraph.Edge> edges) {
		super(vertices, edges);
	}
	
	public UnWeightedGraph(List<AbstractGraph.Edge> edges,
			int numOfVertices){
		super(edges, numOfVertices);
	}
}
