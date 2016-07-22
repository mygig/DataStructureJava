package doubleLinkedLIst;

import java.util.Scanner;

public class DoubleLinkedList {
	private Node start;

	// constructor
	public DoubleLinkedList() {
		start = null;
	}

	// method to display list
	public void displayList() {
		Node p;

		if (start == null) {
			System.out.println("List is empty");
			return;
		}

		p = start;
		System.out.println("List is:\n");
		while (p != null) {
			System.out.println(p.info + " ");
			p = p.next;
		}
		System.out.println();
	}

	// insert node at beginning
	public void insertInBeginning(int data) {
		Node temp = new Node(data);
		temp.next = start;
		start.prev = temp;
		start = temp;
	}

	// insert in empty list
	public void insertInEmptyList(int data) {
		Node temp = new Node(data);
		start = temp;
	}

	// insert at the end of the list
	public void insertAtEnd(int data) {
		Node temp = new Node(data);

		Node p = start;
		while (p.next != null) {
			p = p.next;
		}
		p.next = temp;
		temp.prev = p;
	}

	// create list
	public void createList() {
		int i, n, data;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of nodes!");
		n = scan.nextInt();

		if (n == 0) {
			return;
		}
		System.out.println("Enter the first node");
		data = scan.nextInt();
		insertInEmptyList(data);
		for (i = 2; i <= n; i++) {
			System.out.println("Enter the next element to be inserted!");
			data = scan.nextInt();
			insertAtEnd(data);
		}

	}

	// insert after a given node
	public void insertAfter(int data, int x) {
		Node temp = new Node(data);
		Node p = start;

		while (p != null) {
			if (p.info == x) {
				break;
			}
			p = p.next;
		}
		if (p == null) {
			System.out.println(x + "not present in the list");
		} else {
			temp.prev = p;
			temp.next = p.next;
			// make sure p does not refers to the last node
			if (p.next != null) {
				p.next.prev = temp;
			}
			p.next = temp;
		}

	}

	// insert before a given node
	public void insertBefore(int data, int x) {
		Node temp = new Node(data);
		Node p = start;

		if (start == null) {
			System.out.println("List is empty");
			return;
		}
		if (start.info == x) {
			temp.next = start;
			start.prev = temp;
			start = temp;
		}

		while (p != null) {
			if (p.info == x) {
				break;
			}
			p = p.next;
		}
		if (p == null) {
			System.out.println(x + "not present in the list");
		} else {
			temp.prev = p.prev;
			temp.next = p;
			p.prev.next = temp;
			p.prev = temp;
		}
	}

	// delete first node
	public void deleteFirstNode() {
		if (start == null) {
			return;
			// list is empty
		}
		if (start.next == null) {
			start = null;
			return;
			// list has only one node
		}
		start = start.next;
		start.prev = null;

	}

	// delete last node
	public void deleteLastNode() {

		if (start == null) {
			return;
		}
		if (start.next == null) {
			start = null;
			return;
			// list has only one node
		}
		Node p = start;
		while (p.next != null) {
			p = p.next;
		}

		p.prev.next = null;
	}

	// delete a specified node
	public void deleteNode(int x) {
		if (start == null) {
			return;
		}
		if (start.next == null) {
			// list has only one node
			if (start.info == x) {
				start = null;

			} else {
				System.out.println(x + "not found");
				return;
			}
			// if list has more than one node
			if (start.info == x) {
				start = start.next;
				start.prev = null;
				return;
			}

		}
		Node p = start;
		// p keeps track of current node
		while (p.next != null) {
			if (p.info == x) {
				break;
			}
			p = p.next;
		}
		if (p.next != null) {
			// node to be deleted is in between
			p.prev.next = p.next;
			p.next.prev = p.prev;
		} else {
			// p refers to the last node
			if(p.info==x){
				p.prev.next = null;
			}else{
				System.out.println(x+ "not found");
			}
			
		}
	}
	
	// reverse the list 
	public void reverseList(){
		if(start ==  null) {
			return;
		}
		Node p1 = start;
		Node p2 = p1.next;
		p1.next = null;
		p1.prev=p2;
		while(p2!= null){
			p2.prev=p2.next;
			p2.next=p1;
			p1=p2;
			p2=p2.prev;
			
		}
		start=p1;
	}

}
