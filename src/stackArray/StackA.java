// Array based implementation of stack.
package stackArray;

import java.util.EmptyStackException;

public class StackA {

	private int [] stackArray;
	private int top;

	public StackA() {
     stackArray = new int[10];
     top = -1;    
	}
	
	public StackA(int maxSize){
		stackArray = new int[maxSize];
		top=-1;
	}

	public int size(){
		// return number of elements in the stack
		return top+1;
	}
	public boolean isEmpty(){
		return (top == -1);
	}
	public boolean isFull(){
		// when top refers to the last index of the array.
		return (top == stackArray.length-1);
	}
	
	public void push(int x){
		if(isFull()){
			System.out.println("Stack overflow !");
			return;
		}
		top=top+1;
		stackArray[top]=x;
	}
	public int pop(){
		int x;
		if(isEmpty()){
			System.out.println("stack underflow");
			throw new EmptyStackException();
			
		}
		x= stackArray[top];
		top=top-1;
		return x;
		
		
	}
	public int peek(){
		// return the top element
		if(isEmpty()){
			System.out.println("stack underflow");
			throw new EmptyStackException();
		}
		return stackArray[top];
	}
	public void display(){
		
		if(isEmpty()){
			System.out.println("stack is empty");
			return;
		}
		
		for(int i = top;i>=0;i--){
			System.out.println(stackArray[i] + " ");
		}
		System.out.println();
	}
}
