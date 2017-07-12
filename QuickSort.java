import java.util.Arrays;
import java.util.Scanner;
 
/** Class QuickSort **/
public class QuickSort 
{
    
    public static void sort(int[] arr)
    {
        quickSort(arr, 0, arr.length - 1);
    }
    
    public static void quickSort(int arr[], int low, int high) 
    {
        int i = low, j = high;
        int temp;
        int pivot = arr[(low + high) / 2];
 
        /** partition **/
        while (i <= j) 
        {
        	while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) 
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
                System.out.println(Arrays.toString(arr) + "i " + i + "j " + j);
            }
          
        }
 
        if (low < j)
            quickSort(arr, low, j);
        /** recursively sort upper half **/
        if (i < high)
            quickSort(arr, i, high);
    }
    /** Main method **/
    public static void main(String[] args) 
    {
        int arr[] = {23,3,4,56,34,12,10};
    	quickSort(arr,0,arr.length-1);
        System.out.println("\nElements after sorting ");        
    	
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");            
        System.out.println();            
    }    
}