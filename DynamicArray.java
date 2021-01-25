class DynamicArray <T>{
	int length = 0;
	int capacity = 0;
	T arr[];

	public T[] createArray(int capacity){
		//System.out.println("in createArray block");
		this.capacity = capacity;
		T newArr[] = (T[])new Object[capacity];
		return newArr;
	}

	public void copyElements(T sourceArray[], T destinationArray[],int tillIndex){
		//System.out.println("in copyElements block");
		System.out.println(sourceArray);
		System.out.println(destinationArray);
		int i = 0 ;
		while(i<=tillIndex){
			destinationArray[i] = sourceArray[i];
			i++;
		}
	}

	public void makeSpace(){
		//System.out.println("in makeSpace block");
		if(length==0){
			arr = createArray(2);
		}
		if(length == capacity){
			T newArr[] = (T[])createArray(capacity*2);
			//System.out.println("created a new array");
			//System.out.println("arr--> "+arr);
			//System.out.println("newArr--> "+newArr);
			copyElements(arr,newArr,length-1);
			arr= newArr;
		}
	}


	public void push(T data){
		//System.out.println("in push block");
		makeSpace();
		arr[length] = data;
		length++;
	}

	public void addElementAtIndex(int index, T data){
		makeSpace();
		//shifting of elements
		for(int i=length;i>index;i--){
			arr[i] = arr[i-1];
		}
		arr[index] = data;
		length++;
	}

	public void pop(){
		T newArr[] = createArray(length-1);
		copyElements(arr,newArr,length-2);
		arr = newArr;
		length--;
	}

	public void deleteElemAtIndex(int index){
		T newArr[] = createArray(length-1);
		//shifting of elements
		for(int i=index;i<length-1;i++){
			arr[i] = arr[i+1];
		}
		copyElements(arr,newArr,length-2);
		arr = newArr;
		length--;
	}

	public void displayElements(){
		//System.out.println("in displayElements block");
		for(T data : arr){
			if(data==null){break;}
			System.out.print(data+"\t");
		}
		System.out.print("\n");
	}

	public int getLength(){
		return this.length;
	}

	public int getCapacity(){
		return this.capacity;
	}

}