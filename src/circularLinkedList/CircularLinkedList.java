package circularLinkedList;

import java.util.Scanner;

public class CircularLinkedList {
	// refers to the last node of the list
	private Node last;

	// constructor
	public CircularLinkedList() {
		last = null;
	}
	public void createList() {
		int i, n, data;

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the number of nodes");
		n = scan.nextInt();

		if (n == 0) {
			return;
		}
		System.out.println("Enter the element to be inserted");
		data=scan.nextInt();
		insertInEmptyList(data);

		for (i = 2; i <= n; i++) {
			System.out.println("enter the element to be inserted");
			data = scan.nextInt();
			insertAtEnd(data);

		}
	}
	public void displayList() {
		// p refers to the current node
		Node p;
		if (last == null) {
			System.out.println("list is empty");
			return;
		}
		// here p refers to the first node of the list
		p = last.link;

		do {
			System.out.println(p.info + "");
			p = p.link;
		} while (p != last.link);
		System.out.println();
	}

	// insert in the beginning
	public void insertInBeginning(int data) {
		Node temp = new Node(data);
		temp.link = last.link;
		last.link = temp;

	}

	public void insertInEmptyList(int data) {
		Node temp = new Node(data);
		last = temp;
		last.link = last;
	}

	public void insertAtEnd(int data) {
	
		Node temp = new Node(data);	
		temp.link = last.link;
		last.link = temp;
		last = temp;
	}
	
	public void insertAfter(int data, int x){
		Node p = last.link;
		do{
			if(p.info==x){
				break;
			}
			p=p.link;
		}while(p!=last.link);
		
		if(p==last.link && p.info!=x){
			System.out.println(x+"not present in the list");
		}else{
			Node temp = new Node(data);
			temp.link = p.link;
			p.link=temp;
			if(p == last){
				last = temp;
			}
		}
	}
	// delete first node
	public void deleteFirstNode(){
		if(last == null){
			// list is empty
			return;
		}
		
		if(last.link==last){
			// list has only one node
			last = null;
			return;
		}
		last.link=last.link.link;
	}
	
	// delete last node 
	public void deleteLastNode(){
		if(last == null){
			// list is empty
			return;
		}
		
		if(last.link==last){
			// list has only one node
			last = null;
			return;
		}
		Node p = last.link;
		while(p.link!=last){
			p=p.link;
		}
		p.link=last.link;
		last=p;
	}
	public void deleteNode(int x){
		if(last==null){
			// list is empty
			return;
		}
		if(last.link==last && last.info==x){
			// deletion of only node 
			last = null;
			return;
		}
		// deletion of first node
		if(last.link.info==x){
			last.link=last.link.link;
			return;
		}
		Node p = last.link;
		while(p.link!=last.link){
			if(p.link.info==x){
				break;
			}
			p=p.link;
		}
		
		if(p.link==last.link){
			System.out.println(x+"not found in the list");
		}else{
			p.link=p.link.link;
			if(last.info==x){
				last=p;
			}
		}
	}
	public void concatenate(CircularLinkedList list){
		
		if(last==null){
			// first list is empty
			last=list.last;
			return;
		}
		if(list.last==null){
			// if second list is empty
			return;
		}
		// keep track of the first node of first list
		Node p = last.link;
		last.link=list.last.link;
		list.last.link=p;
		last=list.last;
		
	}
}
