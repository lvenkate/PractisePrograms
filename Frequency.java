import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class Frequency {

	public static void frequency(int[] array){
		HashMap<Integer ,Element> list = new HashMap<Integer,Element>();
		for(int i =0 ;i< array.length ;i++){
	    if(list.containsKey(array[i])){
	    	Element e = list.get(array[i]);
	    	e.count++;
	    list.put(array[i],e);	
	    }	
	    else{
	    	Element e = new Element(array[i],1,i) ;
	    	list.put(array[i], e);
	    }
	}
		LinkedList<Map.Entry<Integer, Element>> e = new LinkedList<Map.Entry<Integer, Element>>(list.entrySet());
		Collections.sort(e,new Comparator<Map.Entry<Integer ,Element>>(){
		 	@Override
			public int compare(Entry<Integer, Element> o1, Entry<Integer, Element> o2) {
				 	if(o1.getValue().count != o2.getValue().count){
				 		 return (o1.getValue().count  < o2.getValue().count==true) ?-1:1;
				 	}
				 	else{
				 		 return o1.getValue().element < o2.getValue().element ? -1:1;
				 	}
			}
		});
		for(Map.Entry<Integer, Element> m: e){
		System.out.println(m.getValue().toString());
	}
}	
	public static void main(String[] arg){
		 int arr[] = {5, 2, 2, 6, -1, 9999999, 5, 8, 8, 8};
		 frequency(arr);
	}
}
class Element{
	
	int element;
	int count;
	int firstIndex;
	
	public Element(int element, int count, int firstIndex){
		this.element = element;
		this.count = count;
		this.firstIndex = firstIndex;
	}
	public String toString(){
		return this.element + " " + this.count + "  "+ this.firstIndex  ;
	}
} 


