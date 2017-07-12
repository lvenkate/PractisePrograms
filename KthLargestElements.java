import java.util.*;

public class KthLargestElements {
	
	public static void minHeap(int[] arr, int k){
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k+1);
		for(int i =0 ; i< k  ; i++)
			{pq.offer(arr[i]);
			}
	
	
		for(int i=k;i< arr.length ;i++){
			if(pq.peek()<arr[i]){
				pq.offer(arr[i]);
			}
			
			if(pq.size()> k)
 			 pq.poll();
		}
		
		System.out.println("--------------------");
		for(int j: pq){
			System.out.println(j);
		}
		
		
		
		
	}

	public static void main(String[] arr){
		int ar[] = {2,5,7,2,4,6,12,43};
		minHeap(ar, 3);
	}
	
}
