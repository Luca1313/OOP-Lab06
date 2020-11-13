package it.unibo.oop.lab06.generics1;

public class NodeForDijkstra<T> {
	private T node;
	private NodeForDijkstra<T> predecessor;
	private int distanceToDestination;
	private boolean visited;
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public NodeForDijkstra(T node, int firstDistance) {
		this.node = node;	this.predecessor = null;
		this.distanceToDestination = firstDistance;	this.visited = false;
	}

	public T getNode() {
		return this.node;
	}

	public void setNode(T node) {
		this.node = node;
	}

	public NodeForDijkstra<T> getPredecessor() {
		return this.predecessor;
	}

	public void setPredecessor(NodeForDijkstra<T> predecessor) {
		this.predecessor = predecessor;
	}

	public int getDistanceToDestination() {
		return this.distanceToDestination;
	}

	public void setDistanceToDestination(int distanceToDestination) {
		this.distanceToDestination = distanceToDestination;
	}
}
