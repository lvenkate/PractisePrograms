
public class Repeat {
	
	public static void repeat(int[] arr){
		int n = arr.length;
		for(int i =0 ;i< arr.length ;i++){
			arr[arr[i] % n ] += n;
		}
		for(int i:arr){
			if(i/n == 2){
				System.out.println(i%n);
			}
		}
	}
	 public static void main(String[] args) 
	    {
	        int arr[] = {4, 2, 4, 5, 2, 3, 1};
	        repeat(arr);
	    }
}
