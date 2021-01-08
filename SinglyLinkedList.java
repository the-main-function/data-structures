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

}