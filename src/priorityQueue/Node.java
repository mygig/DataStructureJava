package priorityQueue;

public class Node {

	// member variables
	public int priority;
	public int info;
	public Node link;
	
	// constructor
	
	public Node(int i, int p){
		info=i;
		priority=p;
		link = null;
	}
}
