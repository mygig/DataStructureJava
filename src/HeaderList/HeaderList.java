package HeaderList;

import java.util.Scanner;

public class HeaderList {
 
	private Node head;
  
  public HeaderList(){
	  head = new Node(0);
  }
  
  public void displayList(){
	  
	  if(head.link == null){
		  System.out.println("List is empty");
		  return;
	  }
	  Node  p = head.link;
	  System.out.println(" List is : \n");
	  while(p!=null){
		  System.out.println(p.info+ " " );
		  p=p.link;
	  }
	  System.out.println();
  }
  
  public void insertAtEnd(int data){
	  Node temp = new Node(data);
	  Node p = head;
	  while(p.link!=null){
		  p=p.link;
	  }
	  p.link=temp;
	  temp.link=null;
  }

	public void createList(){
	  int i, n, data;
	  Scanner scan = new Scanner(System.in);
	  
	  System.out.println("Enter the number of nodes ");
	  n=scan.nextInt();
	  
	  for(i=1;i<=n;i++){
		  System.out.println("Enter the element to be inserted");
		  data=scan.nextInt();
		  insertAtEnd(data);
	  }
  }
  
  public void insertBefore(int data, int x){
	  Node temp;
	  Node p = head;
	  while(p.link!=null){
		  if(p.link.info == x){
			  break;
		  }
		  p=p.link;
	  }
	  
	  if(p.link==null){
		  System.out.println(x+ "not present in the list");
	  } else{
		  temp = new Node(data);
		  temp.link=p.link;
		  p.link=temp;
	  }
  }
  public void insertAtPosition(int data,int k){
	  
	  // k refers the position
	  Node temp;
	  int i ;
	  Node p = head;
	  for(i=1;i<=k-1 && p!=null;i++){
		  p=p.link;
	  }
	  if(p==null){
		 System.out.println("you can not insert new node "); 
	  } else{
		  temp = new Node(data);
		  temp.link=p.link;
		  p.link=temp;
	  }
  }
  public void deleteNode(int data){
	  Node p = head;
	  while(p.link!=null){
		  if(p.link.info==data){
			  break;
		  }
		  p=p.link;
	  }
	  if(p.link==null){
		  System.out.println("Element could not be found");
	  }else{
		  p.link=p.link.link;
	  }
  }
  
  public void reverse(){
	  Node prev, p, next;
	  prev=null;
	  p=head.link;
	  while(p!=null){
		  next=p.link;
		  p.link=prev;
		  prev=p;
		  p=next;
	  }
	  head.link=prev;
  }
}
