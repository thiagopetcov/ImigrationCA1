import java.util.Scanner;

public class DoubleLinkedlist {

static class Person {
	int personid;
	String firstname;
	String lastName;
	String dateofarrivel;
	String passportNumber;
	Priority priority;
 
public Person(int personid, String firstname, String lastName,String dateofarrivel,String passportNumber, Priority priority ){// all my variables
		this.personid = personid;
		this.firstname = firstname;
		this.lastName = lastName;
		this.dateofarrivel = dateofarrivel;
		this.passportNumber = passportNumber;
		this.priority = priority;
		// THE PERSON OBJECT IS READY TO BE MADE
	}
 }
	//node and my node has a person
		class Node {
		
		private Person p;
		
		private Node next;
		private Node previous;
		
		public Node(Person p){
			this.p = p;
			this.next = null;
			this.previous = null;
		}

	}
		enum Priority{
		low,
		medium, //enums set up enumerator 
		high
	}
		Node head;
		Node tail;
		// head and tail both null 
		
		public void addANode(Person p){
			//Create a new node
			Node newNode = new Node(p);
			
		if (head == null){
				//list is empty 
				
				//both head and tail will point to new node
		
				head = tail = newNode;
				//head previous will point to null
				head.previous = null;
				//tail's next will point to null
				tail.next = null;
				
				
				
		}
		else {
				//list is not empty
				//new node is going to be add after the tail such that the tails next will point to the new node
				tail.next = newNode;
				//new node at the end of the list 
				//new node previous will point to the tail
				
				newNode.previous = tail;
				tail = newNode;//SWAP AT THE END OF THE QUEUE
				tail.next = null;
				
				
			}
			
		}
		private void addlowpriority(Person p){
			Node newNode = new Node(p);
			tail.next = newNode;
			//new node at the end of the list 
			//new node previous will point to the tail
			
			newNode.previous = tail;
			tail = newNode;//SWAP AT THE END OF THE QUEUE
			tail.next = null;
			
		}
		private void addhighpriority(Person p){
			Node newNode = new Node(p);
		if (head.p.priority != Priority.high){
				head.previous = newNode;
				//new node at the end of the list 
				//new node previous will point to the tail
				
				newNode.next = head;
				head = newNode;//SWAP AT THE END OF THE QUEUE
				head.previous = null;
				
		}
		else{
				Node temp = new Node(p);//temporary node to search list 
				temp = head; //starting at the head of the list
		while (temp != null){
					temp = temp.next;
					if(temp.p.priority != Priority.high ){
						temp.previous.next = newNode;
			            newNode.next = temp;
			            temp.previous = newNode;
			            newNode.previous = temp.previous;

			            break;
					}
					
				}
				
			}
			
		}
		private void addmediumpriority(Person p){
			Node newNode = new Node(p);
		if (head == null){
				//list is empty 
				
				//both head and tail will point to new node
		
				head = tail = newNode;
				//head previous will point to null
				head.previous = null;
				//tail's next will point to null
				tail.next = null;
				
				
				
			}
		else{
				Node temp = new Node(p);//temporary node to search list 
				temp = head; //starting at the head of the list
		while (temp != null){
					temp = temp.next;
					if(temp.p.priority == Priority.low){
						temp.previous.next = newNode;
			            newNode.next = temp;
			            temp.previous = newNode;
			            newNode.previous = temp.previous;

			            break;
					}
					
				}
				
				
			}
			
			
		}
		//display() will print out the nodes of the list
		  public void display(){
		    //Node current will point to head
		    //start at the beginning of the list
		    Node current = head;
		   if(head == null){ //if the head is null that means the list is empty 
		      System.out.println("List is empty");
		      return;
		    }
		    System.out.println("Nodes of the doubly linked list are as follows: ");
		   while(current != null){
		    	//while we are not at the end at the list than print the current node 
		      //Prints each node by incrementing the pointer

		      System.out.println("First Name: " + current.p.firstname + " || Last Name: " + current.p.lastName + " || Date Of Arrival: " + current.p.dateofarrivel + " || Passport Number: " + current.p.passportNumber + " || Priority Level: " + current.p.priority);
		      current = current.next;//interator just moves to next
		      // moves trought the list 
		    }
		  }
		public static void main(String[] args) {
					Person p1 = new Person(1,"Spider", "man", "24/06/2014","87787", Priority.low);
					//create an empty doubly linked list
					DoubleLinkedlist doubleLinkedlist = new DoubleLinkedlist();
					doubleLinkedlist.addANode(p1);
					doubleLinkedlist.addANode(p1);
					doubleLinkedlist.addANode(p1);
					doubleLinkedlist.addANode(p1);
					doubleLinkedlist.addANode(p1);
					doubleLinkedlist.addlowpriority(p1);
					
					Person p2 = new Person(1,"Spider", "man", "24/06/2014","87787", Priority.high);
					doubleLinkedlist.addhighpriority(p2);
					Person p3 = new Person(1,"Thiago", "man", "24/06/2014","87787", Priority.high);
					doubleLinkedlist.addhighpriority(p3);
					Person p4 = new Person(1,"Doom", "man", "24/06/2014","87787", Priority.medium);
					doubleLinkedlist.addmediumpriority(p4);
					Person p5 = new Person(1,"quacke", "man", "24/06/2014","87787", Priority.medium);
					doubleLinkedlist.addmediumpriority(p5);
					
					Scanner scanner = new Scanner(System.in);
				      String fName, sName, dt, pportNumber;
				      int pr;
				      Priority prior = null;
				      System.out.println("Please input the person data");
				      System.out.println("Please input the first name");
				      fName = scanner.nextLine();
				      System.out.println("Please input the second name");
				      sName = scanner.nextLine();
				      System.out.println("Please input the date");
				      dt = scanner.nextLine();
				      System.out.println("Please input the passport number");
				      pportNumber = scanner.nextLine();
				      System.out.println("Please input the priority level: 1 for low, 2 for medium, 3 for high");
				      pr = Integer.parseInt(scanner.nextLine());
				      if(pr == 1) {
				    	 prior = Priority.low;
				      }
				      if(pr == 2) {
				    	  prior = Priority.medium;
				      }
				      if(pr == 3) {
				    	  prior = Priority.high;
				      }
				      Person input = new Person(1,fName, sName, dt, pportNumber, prior);
				      if(input.priority == Priority.low) {
				    	  doubleLinkedlist.addlowpriority(input);
				      }
				      if(input.priority == Priority.medium) {
				    	  doubleLinkedlist.addmediumpriority(input);
				      }
				      if(input.priority == Priority.high) {
				    	  doubleLinkedlist.addhighpriority(input);
				      }
					
					doubleLinkedlist.display();
					
				
					
				}
				
 }
 



	
		
		
	


