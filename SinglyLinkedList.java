class SinglyLinkedList <T> {
	
	class Node{
		T data;
		Node next;
		public Node(T data){
			this.data = data;
		}
	}

	Node head;
	Node tail;
	int length = 0;

	//check whether the linked is empty or not
	public boolean isEmpty(){ 
		if(head == null){
			return true;
		}
		else{
			return false;
		}
	}

	
	//recursive code to find length of linked list 
	public int getLengthRecursive(Node node){	// will take head of the linked list as arguement
		if(node==null){
			return 0;
		}
		else{
			return 1 + getLengthRecursive(node.next);
		}
	}

	//iterative loop to find lenght of linked list
	public int getLengthIterative(Node node){	// will take head of the linked list as arguement
		int listLength = 0;
		while(true){
			if(node == null){
				break;
			}
			else{
				listLength++;
				node = node.next;
			}
		}
		return listLength;
	}

	//displays the elements of the linked list
	public void show(){
		System.out.println();
		Node trav = head;  
		while(true){
			System.out.print(trav.data + "\t");
			if(trav.next == null){
				break;
			}
			else{
				trav = trav.next;
			}
		}
		System.out.println("\n");
	}

	//-------------------------methods to add elements to the linked list-------------------//

	// adds element at the end of the list
	public void addElem(T data){  
		Node newNode = new Node(data);
		if(isEmpty()){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = newNode;
		}
		length++;
		show();
	}


	//adding element to the front of the linked list
	public void addElemToFront(T data){
		if(head==null){
			addElem(data);
		}

		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		show();
	}
	
	//addding element to the end of the linked list 
	public void addElemToEnd(T data){
		addElemToEnd(data); //addElem() and addElemToEnd() both add node at the end
	}

	//inserting node after a particular elements ..first come first serve (in case of duplicate elements)
	public void addELementAfter(T after_data , T data){
		Node newNode = new Node(data);
		//traverse till node after which new node is to be added
		Node trav =  head;
		while(trav.next != null){
			if(trav.data.equals(after_data)){
				break;
			}
			else{
				trav = trav.next;
			}
		}

		if(trav.next == null){
			addElem(data); //addElemAtEnd(data) can also be used;
		}
		else{
			newNode.next = trav.next;
			trav.next = newNode;
		}
		show();
	}
	//--------------------------------------------------------------------------------//

	//------------------------methods to delete element from a linked list------------//
	public void deleteFirstElem(){
		Node trav = head;
		head = head.next;
		trav.next = null;
		length--;
		show();
	}

	public void deleteLastElem(){
		Node temp = head;
		Node prev = null; // will point to the previous node
		while(temp.next!=null){
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
		tail = prev;
		length--;
		show();
	}

	public void deleteElemAtKey(T key){
		Node trav = head;
		Node prev = null;
		//if the key is at head itself then we call deleteFirstElem()
		if(head.data.equals(key)){
			deleteFirstElem();
			return;
		}

		while(trav.next != null && !trav.data.equals(key)){
			prev = trav;
			trav = trav.next;
		}
		//after the while loop the trav variable points to the key node and prev one node before the key
		prev.next = trav.next;
		trav.next = null; 

		//if prev.next == null that means it is the last element of the linked list
		//and hence the tail is made to point to it 
		if(prev.next == null){
			tail = prev;
		}
		length --;	
		show();	
	}
	//-----------------------------------------------------------------------------//
	public int getLength(){
		return length;
	}

	public int getHead(){
		return head;
	}

	public int getTail(){
		return tail;
	}
	//---------------------------------------------------------------------------//
	public static void main(String[] args) {
		SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>();
		s.addElem(12);
		s.addElem(96);
		s.addElem(31);
		s.addElem(82);
		s.addElem(19);
		s.addElemToFront(27);
		s.deleteFirstElem();
		s.addELementAfter(82,64);
		s.deleteElemAtKey(31);
		s.deleteElemAtKey(19);
		s.deleteElemAtKey(12);
	}

}