package queueArray;

import java.util.Scanner;

import stackArray.StackA;

public class Demo {
	public static void main(String args[]) {
		int choice, x;

		Scanner scan = new Scanner(System.in);

		QueueA qu = new QueueA(8);

		while (true) {
			System.out.println("1. insert a element in the queue");
			System.out.println("2. delete a element from queue");
			System.out.println("3. Display element at front");
			System.out.println("4. Display all element");
			System.out.println("5. Display size of the queue");
			System.out.println("6. Quit");
			System.out.println("7. Enter your choice");

			choice = scan.nextInt();

			if (choice == 6) {
				break;
			}
			
			switch (choice) {

			case 1:
				System.out.println("Enter element to be inserted");
				x = scan.nextInt();
				qu.insert(x);
				break;

			case 2:
				x = qu.delete();
				System.out.println("deleted element is " + x);
				break;
			case 3:
				System.out.println("Element at the top is " + qu.peek());
				break;

			case 4:
				qu.display();
				break;

			case 5:
				System.out.println("size of stack is" + qu.size());
				break;
				
				default:
					System.out.println("Wrong choice");
			}

		}
		scan.close();
	}
}
