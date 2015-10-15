package graph;

import graph.AbstractGraph.WeightedEdge;
import graph.WeightedGraph.ShortestPathTree;

import java.util.ArrayList;
import java.util.List;

public class WeightedNineTail extends NineTail {
	public WeightedNineTail(){
		List<WeightedEdge>edges = getEdges();
		WeightedGraph graph = new WeightedGraph(edges, NUMOFVERTICES);
		this.tree = graph.getShortesPath(NUMOFVERTICES-1);
	}
	public List<WeightedEdge>getEdges(){
		List<WeightedEdge>edges = new ArrayList<>();
		for(int i=0;i<NUMOFVERTICES;i++){
			for(int j=0;j<MATRIXSIZE;j++){
				char[] node = getNode(i);
				int v = getFlipedNode(node, j);
				int weight = getWeight(j);
				edges.add(new WeightedEdge(v, i, weight));
				}
			}
		return edges;
		
	}
	private int getWeight(int j) {
		int weight=0;
		switch (j) {
			case 0:
			case 2:
			case 6:
			case 8:
				weight=3;
				break;
			case 4:
				weight = 5;
			default:
				weight=4;
				break;
		}
		return weight;
	}
	
}
