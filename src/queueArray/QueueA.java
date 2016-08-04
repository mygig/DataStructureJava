package queueArray;

import java.util.NoSuchElementException;

public class QueueA {
	
	private int[] queueArray;
	private int front; // deletion
	private int rear; // insertion
	
	public QueueA(){
		queueArray = new int[10];
		front = -1;
		rear = -1;
	}

	public QueueA(int maxSize){
		queueArray = new int[maxSize];
		 front = -1;
		 rear = -1;
	}
	public boolean isEmpty(){
		return (front == -1 || front == rear+1);
	}
	
	public boolean isFull(){
		// full when rear becomes equal to last index
		return (rear == queueArray.length-1);
	}
	public int size(){
		if(isEmpty())
			return 0;
		else
			return rear-front+1;
	}
	public void insert(int x){
		if(isFull()){
			System.out.println("queue overflow");
			return;
		}
		
		if(front == -1){
			front=0;
		}
		rear=rear+1;
		queueArray[rear]=x;
	}
	
	public int delete(){
		int x;
		if(isEmpty()){
			System.out.println("Queue underflow");
			throw new NoSuchElementException();
		}
		x=queueArray[front];
		front=front+1;
		return x;
	}
	public int peek(){
		if(isEmpty()){
			System.out.println("Queue underflow");
			throw new NoSuchElementException();
		}
		return queueArray[front];
	}
	
	public void display(){
		int i;
		if(isEmpty()){
		System.out.println("Queue is empty");
		return;
		}
		System.out.println("Queue is");
		for(i=front;i<=rear;i++){
			System.out.println(queueArray[i]);
		}
		System.out.println();
	}
}
