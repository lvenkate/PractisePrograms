import java.util.HashSet;

public class ArrayPairs {
	
	public static void main(String[] args){
		int A[] = {1, 4, 45, 6, 10, 8};
        int n = 16;
        printPairs(A, n );
		
		
	}
	
	static void printPairs(int[] a, int n){
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for(int i=0 ;i< a.length ;i++){
			if(hs.contains(n-a[i])){
				System.out.println("True");
			}
			else
				hs.add(a[i]);
		}
		
	}

}
