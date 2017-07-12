import java.util.PriorityQueue;
import java.util.Random;

public class KSorted {

	public static int[] kSort(int[] a, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int j=0;
		int[] result = new int[a.length];
		for(int i: a){
			pq.offer(i);
			if(pq.size() > k+1){
				result[j++]=pq.poll();
			}
		}
		 while(j<a.length && !pq.isEmpty())
			 result[j++]=pq.poll();
		return result;
		
	}
	
	public static int findKthLargest(int[] nums, int k) {
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k+1);
	    for(int i: nums){
	        q.offer(i);
	 
	        if(q.size()>k){
	            q.poll();
	        }
	    }
	 
	    return q.peek();
	}
	
	
	public static int[] RandomizeArray(int[] array){
		Random rgen = new Random();  // Random number generator			
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    int temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}
	public static void main(String[] arr){
		   int k = 3;
		    int ar[] = {2, 6, 3, 12, 56, 8};
		    int[] result=kSort(ar, k);
		    result = RandomizeArray(ar);
		    for(int i:result){
		    	//System.out.println(i);
		    }
		    System.out.println(findKthLargest(ar,3));
	}
	
}
