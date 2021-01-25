class MergeArrays {
	public int[] mergeArrays(int arr[], int brr[]){
		int totalLength = arr.length + brr.length;
		int mergedArr[] = new int[totalLength];
		int index = 0;
		int i = 0;
		int j = 0;

		if(arr==null){
			return brr;
		}

		if(brr == null){
			return arr;
		}

		while(i<arr.length && j<brr.length){
			if(arr[i]<brr[j]){
				mergedArr[index] = arr[i];
				i++;
				System.out.println("i = "+ i + " j =" + j);	
			}
			else{
				mergedArr[index] = brr[j];
				j++;
				System.out.println("i = "+ i + " j =" + j);		
			}
			index++;
			System.out.println(index);
		}

		//copying the remaining elements 
		while(i<arr.length){
			mergedArr[index] = arr[i];
			i++;
			index++;
		}
		while(j<brr.length){
			mergedArr[index] = brr[j];
			j++;
			index++;
		}
		return mergedArr;
	}
}