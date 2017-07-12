import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class PairSum{
	int first;
	int sec;
	int sum;
}
public class quadrasum {

	public static boolean noCommon(PairSum a, PairSum b){
		if(a.first == b.first || a.sec == b.first || a.first == b.sec || a.sec == b.sec)
		
		return false;
		return true;
	}
	
	public static void fourElementSum(int[] arr , int X){
		
		ArrayList<PairSum> ps = new ArrayList<PairSum>();
		
		int n = arr.length;
		  for (int i = 0; i < n-1; i++)
		    {
		        for (int j = i+1; j < n; j++)
		        {
		        	  PairSum p = new PairSum(); 
		     		 p.sum = arr[i]+arr[j];
		     		  p.first =i; p.sec =j;
		     		  ps.add(p);
		        }
		    }
	   	Collections.sort(ps, new Comparator<PairSum>(){
			@Override
			public int compare(PairSum o1, PairSum o2) {
				int result= (o1.first < o2.first) ?-1:1;
				return result;
			}
		});
		int l =0, r = n-1;
		while(l<r){
			if(ps.get(l).sum + ps.get(r).sum == X && noCommon(ps.get(l) , ps.get(r)))
					System.out.println(" l " + l + " r " + r + " sum " );
			else if (ps.get(l).sum + ps.get(r).sum > X ) 
				l++;
			else 
				r--;
		}
	}
	
}
