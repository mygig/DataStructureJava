package priorityQueue;

import java.util.Scanner;

public class Demo {
	public static void main(String args[]) {
		int choice, element,elementPriority;

		Scanner scan = new Scanner(System.in);

		PriorityQueue qu = new PriorityQueue();

		while (true) {
			System.out.println("1. insert an element to the queue");
			System.out.println("2. delete an element from queue");
			System.out.println("3. Display all queue element");
			System.out.println("4. Quit");
			System.out.println("5. Enter your choice");

			choice = scan.nextInt();

			if (choice == 4) {
				break;
			}
			
			switch (choice) {

			case 1:
				System.out.println("Enter element to be inserted");
				element = scan.nextInt();
				System.out.println("Enter element priority");
				elementPriority = scan.nextInt();
				qu.insert(element,elementPriority);
				break;

			case 2:
				element = qu.delete();
				System.out.println("deleted element is " + element);
				break;
			case 3:
				qu.display();
				break;
				
				default:
					System.out.println("Wrong choice");
			}

		}
		scan.close();
	}
}
