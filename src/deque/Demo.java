package deque;

import java.util.Scanner;

public class Demo {

	public static void main(String args[]) {
		int choice, x;

		Scanner scan = new Scanner(System.in);

		DequeA st = new DequeA(8);

		while (true) {
			System.out.println("1. insert an element to front of queue");
			System.out.println("2. insert an element rear end of queue");
			System.out.println("3. delete  from front element");
			System.out.println("4. delete  from rear element");
			System.out.println("5. Display all element of the queue");
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
				st.insertFront(x);
				break;

			case 2:
				System.out.println("Enter element to be inserted");
				x = scan.nextInt();
				st.insertRear(x);
				break;
			case 3:
				x = st.deleteFront();
				System.out.println("deleted element is " + x);
				break;

			case 4:
				x = st.deleteRear();
				System.out.println("deleted element is " + x);
				break;

			case 5:
				st.display();
				break;
				
				default:
					System.out.println("Wrong choice");
			}

		}
		scan.close();
	}
}
