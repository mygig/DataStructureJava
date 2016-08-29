package circularQueue;

import java.util.NoSuchElementException;

public class CircularQueue {

	private int[] queueArray;
	private int front;
	private int rear;

	// constructor
	public CircularQueue() {

		// initialize the array with default size
		queueArray = new int[10];
		front = -1;
		rear = -1;
	}

	public CircularQueue(int maxSize) {
		queueArray = new int[maxSize];
		front = -1;
		rear = -1;
	}

	public boolean isEmpty() {
		return (front == -1);
	}

	public boolean isFull() {
		return (front == 0 && rear == queueArray.length - 1)
				|| (front == rear + 1);
	}

	public void insert(int x) {
		if (isFull()) {
			System.out.println("queue overflow");
			return;
		}

		if (front == -1) {
			front = 0;
		}
		if (rear == queueArray.length - 1) {
			rear = 0;
		} else {
			rear = rear + 1;
			queueArray[rear] = x;
		}
	}

	public int delete() {
		if (isEmpty()) {
			System.out.println("queue underflow");
			throw new NoSuchElementException();
		}
		int x = queueArray[front];
		// queue has only one element
		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (front == queueArray.length - 1) {
			front = 0;
		} else {
			front = front + 1;
		}
		return x;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("queue underflow");
			throw new NoSuchElementException();
		} else {
			return queueArray[front];
		}
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
	
	public int size(){
		if(isEmpty()){
			return 0;
		}
		if(isFull()){
			return queueArray.length;
		}
		
		int i = front ;
		int sz=0;
		if(front<=rear){
			while(i<=rear){
				sz++;
				i++;
			}
			
		}else {
			while(i<=queueArray.length-1){
				sz++;
				i++;
			}
			i=0;
			while(i<=rear){
				sz++;
				i++;
			}
		}
		return sz;
	}
}
