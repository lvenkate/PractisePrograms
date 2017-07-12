public  class CountConversions {

     CountConversions() {}

    public static int countInversions(int[] a) {
        return mergeSort(a, 0, a.length);
    }

    private static int mergeSort (int[] a, int low, int high) {
        if (low == high - 1) return 0;
        int mid = (low + high)/2;
        System.out.println(low + " " +  high);
        return mergeSort (a, low, mid) + mergeSort (a, mid, high) + merge (a, low, mid, high);
    }

    private static int merge (int[] a, int low, int mid, int high) {
        int count = 0;
        int[] temp = new int[a.length];
        for (int i = low, lb = low, hb = mid; i < high; i++ ) {
           if (hb >= high || lb < mid && a[lb] <= a[hb]) {
                temp[i]  = a[lb++];
            } else {
                count = count + (mid - lb); 
                temp[i]  = a[hb++];
            } 
       }
       System.arraycopy(temp, low, a, low, high - low);
       return count;
    }
    
    public static void main(String[] args){
    	int[] array = {2,4,3,1,1};
    	System.out.println(countInversions(array));
    }
}