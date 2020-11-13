package it.unibo.oop.lab06.generics1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<T> implements Graph{
	
	private Map<T, HashSet<T>> graph;
	
	public GraphImpl() {
		this.graph = new HashMap<T, HashSet<T>>();
	}
	
	@SuppressWarnings("unchecked")
	public void addNode(Object node) {
		if (node != null && !this.graph.keySet().contains((T)node)) {
			this.graph.put((T)node, new HashSet<T>());
		}
	}

	@SuppressWarnings("unchecked")
	public void addEdge(Object source, Object target) {
		if (source != null && target != null && this.graph.keySet().contains((T)source)) {
			this.graph.get((T)source).add((T)target);
		}
	}

	public Set<T> nodeSet() {
		Set<T> newSet = new HashSet<>();
		
		for (T elements: this.graph.keySet()) {
			newSet.add(elements);
		}
		return newSet;
	}

	@SuppressWarnings("unchecked")
	public Set<T> linkedNodes(Object node) {
		if (node != null && this.graph.keySet().contains((T)node)) {
			Set<T> newSet = new HashSet<>();
			for(T elements: this.graph.get((T)node)) {
				newSet.add(elements);
			}
		return newSet;
		} else {
			return null;
		}
	}
	
	private void relax(NodeForDijkstra<T> firstNode, NodeForDijkstra<T> secondNode, int weight) {
		if(secondNode.getDistanceToDestination() > (firstNode.getDistanceToDestination() + weight)) {
			secondNode.setDistanceToDestination(firstNode.getDistanceToDestination() + weight);
			secondNode.setPredecessor(firstNode);
		}
	}
	
	@SuppressWarnings("unchecked")
	private List<T> search(Object source, Object target) {
		List<T> returnPath = new ArrayList<>();
		List<NodeForDijkstra<T>> listDijkstra = new ArrayList<>();
		
		listDijkstra.add(new NodeForDijkstra<T>((T)source, 0));
		
		for(T elements: this.graph.keySet()) {
			if (!elements.equals((T)source)){
				listDijkstra.add(new NodeForDijkstra<T>(elements, Integer.MAX_VALUE));
			}
		}
		for(int i = 0; i < listDijkstra.size(); i++) {
			NodeForDijkstra<T> minimumLimit = null;
			int superiorLimit = Integer.MAX_VALUE;
			for(NodeForDijkstra<T> node: listDijkstra) {
				if(!node.isVisited() && node.getDistanceToDestination() < superiorLimit) {
					superiorLimit = node.getDistanceToDestination();
					minimumLimit = node;
				}
			}
			minimumLimit.setVisited(true);
			for (T adj: this.graph.get((T)minimumLimit.getNode())) {
				for (NodeForDijkstra<T> node: listDijkstra) {
					if(!node.isVisited() && node.getNode().equals(adj))
						relax(minimumLimit, node, 1);
				}
			}
		}
		int index = 0;
		for (NodeForDijkstra<T> node: listDijkstra) {	//Looking for the target node
			if(node.getNode().equals((T)target)) {
				index = listDijkstra.indexOf(node);
			}
		}
		
		if(listDijkstra.get(index).getPredecessor() != null) {
			returnPath.add((T)source);
			NodeForDijkstra<T> temporaryNode = listDijkstra.get(index);
			while (temporaryNode.getPredecessor().getNode() != (T)source) {
				NodeForDijkstra<T> temporaryLoopNode = temporaryNode;
				while (temporaryLoopNode.getPredecessor().getNode() != (T)source) { //To obtain the right
					temporaryLoopNode = temporaryLoopNode.getPredecessor();			//Sequence of the path
				}
				returnPath.add(temporaryLoopNode.getNode());
				temporaryNode = temporaryNode.getPredecessor();
			}
			returnPath.add((T)target);
		}
		return returnPath;
	}
	
	public List<T> getPath(Object source, Object target) {
		if (source != null && target != null && this.graph.containsKey(source)
				&& this.graph.containsKey(target)) {
		List<T> path = search(source, target); //Done following the Dijkstra algorithm
		return path;
		}
		return null;
	}

}
