package deque;

import java.util.NoSuchElementException;


public class DequeA {
	// using circular array
	private int[] queueArray;
	private int front;
	private int rear;

	public DequeA() {
		queueArray = new int[10];
		front = -1;
		rear = -1;
	}

	public DequeA(int maxSize) {
		queueArray = new int[maxSize];
		front = -1;
		rear = -1;
	}

	public void insertFront(int x){
		if(isFull()){
			System.out.println("queue is full");
			return;
		}
		if(front == -1){
			front = 0;
			rear = 0;
		} else if(front == 0){
			front = queueArray.length-1;
		}else 
			front =front-1;
			queueArray[front] =x;
		
	}
		public void insertRear(int x){
			if(isFull()){
				System.out.println("queue is full");
				return;
			}
			if(front == -1){
				front = 0;
			}
			if(rear == queueArray.length-1){
				rear=0;
			}else{
				rear=rear+1;
				queueArray[rear]=x;
			}
		}
		
		public int deleteFront(){
			int x;
			if(isEmpty()){
				System.out.println("queue underflow");
				throw new NoSuchElementException();
			}
			x=queueArray[front];
			if(front == rear){
				// only one element
				rear =-1;
				front =-1;
				
			} else if(front == queueArray.length-1){
				front = 0;
			} else 
				front = front+1;
			return x;
			
		}
		
		public int deleteRear(){
			int x;
			if(isEmpty()){
				System.out.println("queue underflow");
				throw new NoSuchElementException();
			}
			
			x=queueArray[rear];
			if(front == rear){
				front = -1;
				rear = -1;
			}
			
			else if(rear == 0){
				rear= queueArray.length-1;
			} else 
				rear=rear-1;
			return x;
		}
		
		public boolean isFull(){
			return((front == 0 && rear == queueArray.length-1) || front==rear+1);
		}
		
	    public boolean isEmpty(){
	    	return (front == -1);
	    }
		public void display() {
			if (isEmpty()) {
				System.out.println("queue is empty");
				return;
			}
			System.out.println("Queue is ");

			int i = front;
			if (front <= rear) {
				while (i <= rear) {
					System.out.println(queueArray[i++] + " ");
				}
			} else {
				// if front is greater than rear
				while (i <= queueArray.length - 1)
					System.out.println(queueArray[i++] + " ");

				i = 0;
				while (i <= rear)
					System.out.println(queueArray[i++] + " ");

			}
			System.out.println();

		}
}
