package singleLinkedList;

import java.util.Scanner;

public class SingleLinkedList {

	// special reference variable to always point to the first node of
	// linkedlist
	private Node start;

	public SingleLinkedList() {
		start = null;
	}

	public void dislplayList() {
		Node p;
		if (start == null) {
			System.out.println("List is empty");
		}
		System.out.print("List is :  ");
		p = start;

		while (p != null) {
			System.out.print(p.info + " ");
			p = p.link;
		}
		System.out.println("");
	}

	// count number of nodes
	public void countNodes() {
		int n = 0;
		Node p = start;
		while (p != null) {
			n++;
			p = p.link;
		}
		System.out.println("Count of the linked list is " + n);
	}

	// search for a given element
	public boolean search(int x) {
		Node p = start;
		int position = 1;
		while (p != null) {
			if (p.info == x)
				break;
			position++;
			p = p.link;
		}
		if (p == null) {
			System.out.println(x + "is not found in the list");
			return false;
		} else {
			System.out.println(x + "is at" + position);
			return true;
		}

	}

	// insert at the begining of the list
	public void insertAtBegining(int data) {
		Node temp = new Node(data);
		temp.link = start;
		start = temp;

	}

	// insert at the end of the list
	public void insertAtEnd(int data) {
		Node p = start;
		Node temp = new Node(data);
		if (start == null) {
			start = temp;
			return;
		}

		p = start;
		while (p.link != null) {
			p = p.link;
		}
		p.link = temp;

	}

	// create list
	public void createList() {
		int i, n, data;

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the number of nodes");
		n = scan.nextInt();

		if (n == 0) {
			return;
		}

		for (i = 1; i <= n; i++) {
			System.out.println("enter the element to be inserted");
			data = scan.nextInt();
			insertAtEnd(data);

		}
	}

	// insert node after a given node
	public void insertAfter(int data, int x) {

		Node p = start;
		while (p != null) {
			if (p.info == x)
				break;
			p = p.link;
		}
		if (p == null) {
			System.out.println(x + "is not present in the list");
		} else {
			Node temp = new Node(data);
			temp.link = p.link;
			p.link = temp;
		}
	}

	// insert node before a given node its little complicated
	public void insertBefore(int data, int x) {
		// if list is empty
		if (start == null) {
			System.out.println("list is empty");
			return;
		}
		// x is the first node, new node has to be inserted before x
		if (x == start.info) {
			Node temp = new Node(data);
			temp.link = start;
			start = temp;
			return;

		}

		// find the predecessor of node containing x;
		Node p = start;
		while (p != null) {
			if (p.link.info == x) {
				break;
			}
			p = p.link;
		}
		if (p.link == null) {
			System.out.println(x + "not found in the list");
		} else {
			Node temp = new Node(data);
			temp.link = p.link;
			p.link = temp;
		}
	}

	// insert a new node at kth postion in the list
	public void insertAtPosition(int data, int k) {
		Node temp;
		int i;

		if (k == 1) {
			temp = new Node(data);
			temp.link = start;
			start = temp;
			return;
		}
		Node p = start;
		// find the reference to k-1 node basically predecessor to kth node;
		for (i = 1; i < k - 1 && p != null; i++) {
			p = p.link;
		}
		if (p == null) {
			System.out.println("you can insert upto " + i + " position");
		} else {
			temp = new Node(data);
			temp.link = p.link;
			p.link = temp;
		}

	}

	// delete first node
	public void deleteFirst() {
		if (start == null) {
			return;
		}
		start = start.link;
	}

	// delete last node
	public void deletelLast() {
		if (start == null) {
			return;
		}
		if (start.link == null) {
			start = null;
			return;
		}

		Node p = start;
		// p.link.link give me second last node
		while (p.link.link != null) {
			p = p.link;
		}
		p.link = null;
	}

	// delete node at given postion
	public void deleteNode(int x) {
		if (start == null) {
			System.out.println("list is empty");
			return;
		}
		if (start.info == x) {
			start = start.link;
			return;
		}
		// delete in between or at last;
		Node p = start;
		while (p.link != null) {
			if (p.link.info == x) {
				break;
			}
			p = p.link;
		}
		if (p.link == null) {
			System.out.println("Element not in the list");
		} else
			p.link = p.link.link;
	}

	// reverse a linkedlist
	public void reverseList() {
		Node next = null, prev, p;
		p = start;
		prev = null;
		while (p != null) {
			next = p.link;
			p.link = prev;
			prev = p;
			p = next;
		}
		start = prev;
	}

	// bubble sort using data
	public void bubbleSortExData() {
		// for loop for the pass
		Node end, p, q;
		for (end = null; end != start.link; end = p) {
			// for loop for sorting element.
			for (p = start; p.link != end; p = p.link) {
				q = p.link;
				if (p.info > q.info) {
					int temp;
					temp = p.info;
					p.info = q.info;
					q.info = temp;
				}
			}
		}
	}

	// bubble sort using links
	public void bubbleSortExLink() {
		// for loop for the pass
		Node end, p, q, r, temp;
		for (end = null; end != start.link; end = p) {
			// for loop for sorting element.
			for (r = p = start; p.link != end; r = p, p = p.link) {
				q = p.link;
				if (p.info > q.info) {
					p.link = q.link;
					q.link = p;
					if (p != start) {
						r.link = q;
					} else
						start = q;
					temp = p;
					p = q;
					q = temp;
				}
			}
		}
	}

	// merging using data elements
	public SingleLinkedList merge1(SingleLinkedList list) {
		SingleLinkedList mergeList = new SingleLinkedList();
		mergeList.start = merge1(start, list.start);
		return mergeList;
	}

	private Node merge1(Node p1, Node p2) {
		// first node of merged list
		Node startM;

		if (p1.info <= p2.info) {
			startM = new Node(p1.info);
			p1 = p1.link;
		} else {
			startM = new Node(p2.info);
			p2 = p2.link;
		}
		// pM refers to the newly inserted node in the merged list or last node
		Node pM = startM;

		while (p1 != null && p2 != null) {

			if (p1.info <= p2.info) {
				pM.link = new Node(p1.info);
				p1 = p1.link;
			} else {
				pM.link = new Node(p2.info);
				p2 = p2.link;
			}
			pM = pM.link;
		}

		// if second list is finished and element left in the first
		while (p1 != null) {
			pM.link = new Node(p1.info);
			p1 = p1.link;
			pM = pM.link;
		}
		// if first list is finished and element left in the second
		while (p2 != null) {
			pM.link = new Node(p2.info);
			p2 = p2.link;
			pM = pM.link;
		}

		return startM;
	}

	// merging using exchanging links

	public SingleLinkedList merge2(SingleLinkedList list) {
		SingleLinkedList mergeList = new SingleLinkedList();
		mergeList.start = merge2(start, list.start);
		return mergeList;
	}

	private Node merge2(Node p1, Node p2) {
		// refers to the first node of merged list
		Node startM;

		if (p1.info < p2.info) {
			startM = p1;
			p1 = p1.link;
		} else {
			startM = p2;
			p2 = p2.link;
		}

		// pM refers to the newly inserted node
		Node pM = startM;

		while (p1 != null && p2 != null) {

			if (p1.info < p2.info) {
				pM.link = p1;
				pM = pM.link;
				p1 = p1.link;
			} else {
				pM.link = p2;
				pM = pM.link;
				p2 = p2.link;
			}
		}

		if (p1 == null) {
			pM.link = p2;
		} else {
			pM.link = p1;
		}

		return startM;
	}

	// find cycle in linked list

	public boolean hasCycle() {
		if (findCycle() == null)
			return false;
		else
			return true;
	}
	
	private Node findCycle(){
		
		if(start == null || start.link ==null){
			return null;
		}
		
		Node slowR = start, fastR=start;
		// if list is null terminated with even number of nodes then fastR =null
		// else if list is odd then fastR.link =null
		
		while(fastR!=null && fastR.link!=null){
			slowR=slowR.link;
			fastR=fastR.link.link;
			
			if(slowR==fastR){
				return slowR;
			}
		}
		
		return null;
	}
	
	// function to remove cycle;
	
	public void removeCycle(){
		Node c = findCycle();
		if(c == null ){
			return ;
		}
		
		System.out.println("Node at which cycle meets was "+c.info);
		
		Node p=c, q=c;
		int lenCycle = 0;
		do{
			lenCycle++;
			q=q.link;
		}while(p!=q);
		
		System.out.println("Lenght of cycle is "+lenCycle);
		
		int lenRemList = 0;
		p=start;
		while(p!=q){
			lenRemList++;
			p=p.link;
			q=q.link;
		}
		System.out.println("Number of node not included in cycle are"+lenRemList);
		int lengthList = lenCycle+lenRemList;
		
		for(int i=0 ;i<lengthList-1; i++){
			p=p.link;
		}
		p.link=null;
	}
	
	//insert a cycle 
	public void insertCycle(int x){
		
		if(start ==  null){
			return;
		}
		
		Node p=start, pX=null,prev=null;
		
		while(p!=null){
			if(p.info == x){
				pX=p;
			}
			prev = p;
			p=p.link;
		}
		
		if(pX != null){
			prev.link=pX;
		}else {
			System.out.println(x + "not present in list");
		}
	}
	public void concatenate(SingleLinkedList list){
		if(start == null ){
			// if first list is empty
			start = list.start;
		}
		if(list.start== null){
			// if second list is null
			// nothing to concatenate
			return;	
		}
		
		Node p = start;
		while(p.link!=null){
			p=p.link;
		}
		//p.link refers to last node of first list
		p.link=list.start;
	}
}
