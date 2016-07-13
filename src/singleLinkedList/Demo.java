package singleLinkedList;

import java.util.Scanner;

public class Demo {
	public static void main(String args[]) {
		int choice, data, k, x;

		Scanner scan = new Scanner(System.in);
		SingleLinkedList list = new SingleLinkedList();
		list.createList();

		while (true) {
			System.out.println("1.Display list");
			System.out.println("2.Count number of nodes");
			System.out.println("3.search for a element");
			System.out.println("4.insert in begining");
			System.out.println("5.insert in end");
			System.out.println("6.insert a node after a specified node");
			System.out.println("7.insert a node before a specified node");
			System.out.println("8.insert a node before at a given position");
			System.out.println("9.delete first node");
			System.out.println("10.delete last node");
			System.out.println("11.delete node at a given position");
			System.out.println("12:reverse the list");
			System.out.println("13:sort list usind data");
			System.out.println("14:sort list usind link");
			System.out.println("15:insert cycle");
			System.out.println("16:detect cycle");
			System.out.println("17:remove cycle");

			System.out.println("Enter your choice");

			choice = scan.nextInt();

			if (choice == 19)
				break;

			switch (choice) {
			case 1:
				list.dislplayList();
				break;
			case 2:
				list.countNodes();
				break;
			case 3:
				System.out.println("Enter the element to be searched");
				data = scan.nextInt();
				list.search(data);
				break;
			case 4:
				System.out.println("Enter element to be inserted");
				data = scan.nextInt();
				list.insertAtBegining(data);
				break;
			case 5:
				System.out.println("Enter element to be inserted");
				data = scan.nextInt();
				list.insertAtEnd(data);
				break;
			case 6:
				System.out.println("Enter the node element value");
				System.out.println("Enter the after node location ");
				data = scan.nextInt();
				x = scan.nextInt();
				list.insertAfter(data, x);
				break;
			case 7:
				System.out.println("Enter the node element value");
				System.out.println("Enter the before node location ");
				data = scan.nextInt();
				x = scan.nextInt();
				list.insertBefore(data, x);
				break;
			case 8:
				System.out.println("Enter the node element value");
				System.out.println("Enter the specific node location ");
				data = scan.nextInt();
				x = scan.nextInt();
				list.insertAtPosition(data, x);
				break;
			case 9:
				System.out.println("delete first node");
				list.deleteFirst();
				break;
			case 10:
				System.out.println("delete last node");
				list.deletelLast();
				break;
			case 11:
				System.out.println("Enter element to be deleted");
				data = scan.nextInt();
				list.deleteNode(data);
				break;
			case 12:
				System.out.println("Reverse the list");
				list.reverseList();
				break;

			case 13:
               System.out.println("sorted list using data");
				list.bubbleSortExData();
				break;
			case 14:
	               System.out.println("sorted list using link");
					list.bubbleSortExLink();
					break;
					
			case 15: 
				System.out.println("insert cycle in list at given node, enter value");
                 int val = scan.nextInt();
                 list.insertCycle(val);
                 break;
                 
			case 16: 
				System.out.println("detect cycle " +list.hasCycle());
				break;
				
			case 17:
				System.out.println("remove cycle");
				list.removeCycle();
				break;
			}
			
		}

	}

}
