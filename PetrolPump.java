import java.util.LinkedList; 
import java.util.Queue;

class Pump{
	char name;
	int petrol;
	int distance;
	Pump(char n ,int p , int d){
		name = n;
		petrol = p;
		distance =d;
	}
}

public class PetrolPump {

	
	public static void printTour(Pump[] arr){
		
		Queue<Pump> q = new LinkedList<Pump>();
		int currentPetrol =arr[0].petrol - arr[0].distance;
        int start=0;
       
		q.add(arr[start]);
		start++;
		while(!q.isEmpty()){
			
				
			while(currentPetrol >= 0 && q.size() != arr.length ){
				currentPetrol +=arr[(start)% arr.length].petrol - arr[(start)% arr.length].distance ;
				
			}
			if(q.size() == arr.length) break;
			while(currentPetrol < 0 || q.isEmpty() ){
				
				q.remove();
			    currentPetrol=0;
			    
			}
		    
			
			
		}
		
		System.out.println(q.peek().name);
		
	}
	
	
	public static void main(String[] arg){
		
		Pump arr[] = {new Pump('A',6, 4), new Pump('B',3, 6), new Pump('C' ,7, 3)}; 
		printTour(arr);
		
		
	}
	
	
	
}
