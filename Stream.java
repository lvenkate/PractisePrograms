import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Stream {

	 Queue<Integer> stream  ;
	 PriorityQueue<Integer> maxHeap;
	 PriorityQueue<Integer> minHeap;
	int size ;
	
	@SuppressWarnings("unchecked")
	public Stream(int k){
		stream = new LinkedList<Integer>();
		maxHeap = new PriorityQueue<Integer>( 200, new Comparator<Integer>(){
			@Override
			public int compare(Integer a , Integer b){
				return a>b ? 1: 0;	
			}


			
		});
		minHeap =  new PriorityQueue<Integer>();
	    size = k;
	}
	
	public String largestNumber(int[] nums) {
	    String[] arr = new String[nums.length];
	    for(int i=0; i<nums.length; i++){
	        arr[i]=String.valueOf(nums[i]);
	    }
	 
	    Arrays.sort(arr, new Comparator<String>(){
	        public int compare(String a, String b){
	            return (b+a).compareTo(a+b);
	        }
	    });
	 
	    
	    StringBuilder sb = new StringBuilder();
	    for(String s: arr){
	    	sb.append(s);
	    }
	 
	    while(sb.charAt(0)=='0'&&sb.length()>1)
	        sb.deleteCharAt(0);
	 
	    return sb.toString();
	}
	
	public void addHeap(int num){
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		
		if(maxHeap.size() <  minHeap.size()){
			maxHeap.offer(minHeap.poll());
		}
		
	}
	
	public int getMedian(){
		if(maxHeap.size()== minHeap.size()){
			return (int) ((double) (maxHeap.peek() + minHeap.peek())/2);
		}
		else
			return maxHeap.peek();
	}
	
	public  void add(int num){
	
		if(stream.size() >=size)
			stream.poll();
			
		stream.add(num);
		
	}

	public  int findSum(){
		int result=0;
		for(Iterator<Integer> it= stream.iterator(); it.hasNext();){
			result += it.next();
		}
	
		return result;
		
	}
	
	public static void main(String[] args){
		int size = 3;
		Stream st = new Stream(size);
        st.add(5);
        st.addHeap(5);
        System.out.println(st.getMedian());
        st.add(20);
        st.addHeap(20);
        st.addHeap(1);
        System.out.println(st.getMedian());
        st.add(1);
        System.out.println(st.findSum());
        int array[] = {11, 4, 5, 56, 23 , 13, 9};
        st.largestNumber(array);
       // int[] result = st.slidingWindow(array,3);
        //for(int r:result)
        	//System.out.println("Result: " + r);
       }
	
	public int[] slidingWindow(int[] array , int k){
		int size = array.length;
		int[] results = new int[size - k +1];
		LinkedList deque = new LinkedList();
		for(int i =0;i< size ; i++){
			if(!deque.isEmpty() && (int)deque.peekFirst() == i-k)
				deque.poll();
			while(!deque.isEmpty() &&  array[(int) deque.peekLast()] < array[i])
				deque.remove();
			
			deque.offer(array[i]);
			if(i+1>=k)
			results[i+1-k]= results[(int) deque.peek()];	
		}
		
		return array;
	}
	
}
