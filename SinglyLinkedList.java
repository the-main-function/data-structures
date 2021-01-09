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
	public int getLengthIterative(Node node){
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

	public int getLength(){
		return length;
	}

}