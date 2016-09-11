package priorityQueue;

import java.util.NoSuchElementException;

public class PriorityQueue {
 
	private Node front;
	
    public  PriorityQueue(){
    	// initial list is empty
    	front = null;
    }
    
    public void insert(int element, int elementPriority){
    	Node temp, p;
    	temp =  new Node(element,elementPriority);
    	// if queue is empty or the element to be added has priority more than element at  the front
    	if(isEmpty() || elementPriority<front.priority){
    		temp.link = front;
    		front = temp;
    	} else {
    		p = front;
    		while(p.link!=null && p.link.priority<=elementPriority){
    			p=p.link;
    		}
    		
    		temp.link = p.link;
    		p.link=temp;
    	}
    }
    
    public int delete(){
    	int element;
    	if(isEmpty()){
    		System.out.println("Queue underflow");
    		throw new NoSuchElementException();
    	} else {
    		element = front.info;
    		front = front.link;
    	}
    	
    	return element;
    }
    
    public boolean isEmpty(){
    	return (front == null);
    }
    
    public void display(){
    	Node p = front;
    	
    	if(isEmpty()){
    		System.out.println("Queue is empty");
    		throw new NoSuchElementException();
    	}
    	
    	while(p!=null){
    		System.out.println("info is " +p.info+ ".........." +"priority is "+p.priority);
    		p=p.link;
    	}
    	System.out.println("");
    }
}
