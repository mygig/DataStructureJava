package singleLinkedList;

public class MergingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLinkedList list1 = new SingleLinkedList();
		SingleLinkedList list2 = new SingleLinkedList();

		list1.createList();
		list2.createList();

		list1.bubbleSortExData();
		list2.bubbleSortExData();

		System.out.println("First list");
		list1.displayList();

		System.out.println("Second list");
		list2.displayList();

		SingleLinkedList list3;
		list3 = list1.merge1(list2);
		System.out.println("Merged List");
		list3.displayList();

//		// original list will not change
//		System.out.println("First list");
//		list1.displayList();
//
//		System.out.println("Second list");
//		list2.displayList();
//
//		list3 = list1.merge2(list2);
//		System.out.println("Merged list");
//		list3.displayList();
//
//		// original list will change
//
//		System.out.println("First list");
//		list1.displayList();
//
//		System.out.println("Second list");
//		list2.displayList();

	}

}
