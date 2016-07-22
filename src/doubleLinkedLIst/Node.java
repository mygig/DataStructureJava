package doubleLinkedLIst;

public class Node {
	
	public Node prev;
	public int info;
	public Node next;

	// constructor
	public Node(int i) {
		info = i;
		prev = null;
		next = null;
	}

}
