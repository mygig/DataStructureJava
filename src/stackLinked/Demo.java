package stackLinked;

import java.util.Scanner;

import stackArray.StackA;

public class Demo {
	public static void main(String args[]) {
		int choice, x;

		Scanner scan = new Scanner(System.in);

		StackL st = new StackL();

		while (true) {
			System.out.println("1. Push an element to the stack");
			System.out.println("2. Pop an element from stack");
			System.out.println("3. Display the top element");
			System.out.println("4. Display all stack element");
			System.out.println("5. Display size of the stack");
			System.out.println("6. Quit");
			System.out.println("7. Enter your choice");

			choice = scan.nextInt();

			if (choice == 6) {
				break;
			}
			
			switch (choice) {

			case 1:
				System.out.println("Enter element to be pushed");
				x = scan.nextInt();
				st.push(x);
				break;

			case 2:
				x = st.pop();
				System.out.println("Popped element is " + x);
				break;
			case 3:
				System.out.println("Element at the top is " + st.peek());
				break;

			case 4:
				st.display();
				break;

			case 5:
				System.out.println("size of stack is" + st.size());
				break;
				
				default:
					System.out.println("Wrong choice");
			}

		}
		scan.close();
	}
}
