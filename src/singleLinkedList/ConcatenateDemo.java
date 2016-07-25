package singleLinkedList;

public class ConcatenateDemo {

	public static void main(String[] args) {
		
		SingleLinkedList List1 = new SingleLinkedList();
		SingleLinkedList List2 = new SingleLinkedList();

		System.out.println("Enter first list");
		List1.createList();
		System.out.println("Enter second list");
		List2.createList();

		System.out.println("First");
		List1.displayList();
		System.out.println("Second");
		List2.displayList();

		List1.concatenate(List2);
		System.out.println("First");
		List1.displayList();
	}
}
