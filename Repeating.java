import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class Repeating {

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];

		int[] result = new int[nums.length - k + 1];

		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {

			if (!queue.isEmpty() && queue.size() >= k) {
				queue.poll();
			}
			while (!queue.isEmpty() && nums[queue.peek()] < nums[i]) {
				queue.remove();
			}

			queue.offer(i);

			if (i + 1 >= k)
				result[i + 1 - k] = nums[queue.peek()];
		}

		return result;
	}

	public static void printRepeating(int[] arr) {

		Set<Integer> hs = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			if (hs.add(arr[i])) {
				System.out.println("Duplicate" + hs.add(arr[i]));
			}
		}
	}

	public static void segEvenOdd(int[] arr) {

		int left = 0, right = arr.length - 1;

		while (left < right) {
			while (arr[left] % 2 == 0 && left < right) {
				left++;
			}
			while (arr[right] % 2 == 1 && right > left) {
				right--;
			}

			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}

		}
	}

	class Intswapper {
		public int value = 0;
	}

	public void swapUtil(Intswapper a, Intswapper b) {
		int temp = a.value;
		a.value = b.value;
		b.value = temp;
	}

	public static int ceilSearch(int[] a, int low, int high, int x) {
		int mid;
		if (x <= a[low])
			return a[low];

		if (x > a[high])
			return -1;

		mid = (low + high) / 2;

		if (a[mid] == x)
			return a[mid];

		if (a[mid] < x) {
			if (a[mid + 1] >= x && mid + 1 <= high)
				return a[mid + 1];
			else
				return ceilSearch(a, low, mid - 1, x);
		}

		else {
			if (a[mid - 1] < x && mid - 1 >= low)
				return a[mid + 1];
			else
				return ceilSearch(a, low, mid - 1, x);
		}

	}

	public static void nextGreaterElement(int[] a) {
		Stack<Integer> stack = new Stack<>();
		int element = 0, next = 0;
		stack.push(a[0]);
		for (int i = 1; i < a.length; i++) {
			next = a[i];

			if (!stack.isEmpty()) {
				element = stack.pop();

				while (element < next) {
					System.out.println("Element " + element + " Next Greater Element " + next);
					if (stack.isEmpty())
						break;
					element = stack.pop();
				}

				if (element > next)
					stack.push(element);
			}

			stack.push(element);
		}
		while (!stack.isEmpty()) {
			element = stack.pop();
			next = -1;
			System.out.println("Element" + element + "Next Greater Element" + next);
		}

	}

	public static void sortedK(int[] a, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int i = 0;
		for (i = 0; i <= k; i++) {
			pq.offer(a[i]);
		}
		for (; i < a.length; i++) {

			if (!pq.isEmpty() && pq.size() == k + 1) {
				System.out.print(pq.poll() + " ");
			}
			pq.offer(a[i]);
		}
		while (pq.isEmpty() != true)
			System.out.print(pq.poll() + " ");
	}

	public static <T> void swap(int[] a, int i, T j) {

		int temp = a[i];
		a[i] = a[(int) j];
		a[(int) j] = temp;
	}

	public static void randomize(int[] a) {

		for (int i = (a.length - 1); i > 1; i--) {
			int j = (int) (((Math.random())) % (i));

			swap(a, i, j);
		}
		for (int i : a)
			System.out.println(a[i] + " ");
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 4, 5, 4, 3, 2 };
		Integer[] a = { 1, 2, 8, 10, 10, 12, 19};
		// printRepeating(arr);
        /*
		Set<Integer> l = new TreeSet<Integer>(new Comparator<Integer>(){
            @Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 >o1 ? 1: -1;
			}
          	});
		for(Integer i : a){
		l.add(i);}
		System.out.println(l.toString());
		*/
		
		int n = a.length;
		int x = 9;
		// int index = ceilSearch(a, 0, n-1, x);
		// System.out.println("The Ceil" + index );

		int next[] = { 11, 9, 6, 4, 25, 65, 11, 78 };
	    /*int result[] = maxSlidingWindow(a, 3);
		for (int b : result) {
			System.out.println(b);
		}*/
		//sortedK( next,  3);
		//randomize(next);
		// System.out.println();
		// nextGreaterElement(next);
		
		int[] array =  {9,9,8,8,8,8,2,2,1};
		
	}

	public static void frequency(int[] array){
		
		
		
		
	}
	
	
	
	

}


		
	
		




