import java.util.*;
public class Employee {
	
    public String name   ; 
    public String title ;
    public String  manager;
    public String location;
    public ArrayList<Employee> directReportee=null; 
    
    
    Employee(String name, String manager, String title, String location){
    	this.name = name ;
    	this.title = title;
    	this.manager=manager;
    	this.location = location;
    	directReportee= new ArrayList<Employee>();
    }
    public String toString(){
    	return this.name +" "+ this.title + " " + this.location + " " + this.manager;
    }
    public void addReportee(Employee e){
    	directReportee.add(e);
    }
    public void dfsUtil(Employee e){
    	
    }
    public static void dfs(Employee employee, HashSet indicator){
    	
    System.out.println(employee.toString());
    indicator.add(employee);
    for(Iterator i =  employee.directReportee.listIterator();i.hasNext();){
         Employee e = (Employee) i.next(); 
         if(!indicator.contains(e)){
        	 indicator.add(e);
        	 dfs(e, indicator);
         }
     }
   }
    
    public static void main(String[] args){
    	
    	ArrayList<Employee> employees =  new ArrayList<Employee>();
    	Employee cto = new Employee("Laks","Laks","CEO","SF");
    	employees.add(cto);
    	employees.add(new Employee("DD","Glynn","Senior Software Engineer","SF"));
    	employees.add(new Employee("Qaseem","Laks","Vice President of Engineering","SF"));
    	employees.add(new Employee("Dave","Qaseem","Software Engineer","Canada"));
    	employees.add(new Employee("Hari","DD","Junior Software Engineer","India"));
    	employees.add(new Employee("Jin","Glynn","Software Engineer","SF"));
   		employees.add(new Employee("Ram","Qaseem","Software Engineer","SF"));
    	employees.add(new Employee("Glynn","Laks","Principal Software Engineer","SF"));
    	employees.add(new Employee("Raghav","Laks","Software Engineer","Canada"));
    
    for(Employee e : employees){
         for(Employee ee:employees){
           if(e.name.compareTo(ee.manager)==0){
        	   e.addReportee(ee);
           } 
          }
    }
    HashSet<Employee> indicator = new HashSet<Employee>();	
       dfs(cto,indicator);
    
}   
 // This is the text editor interface. 
 // Anything you type or change here will be seen by the other person in real time.

 // esundstrom@zenefits.com

 /*
 Create an organizational chart (org chart) from given employee records.
 Employee records are comma separated attributes: Employee Name, Manager Name, Title, Employee Location where each line is a new employee
 If an employee has no manager their own name will be listed as the manager.

 Example Input:
 DD,Glynn,Senior Software Engineer,SF
 Qaseem,Laks,Vice President of Engineering,SF
 Dave,Qaseem,Software Engineer,Canada
 Hari,DD,Junior Software Engineer,India
 Jin,Glynn,Software Engineer,SF
 Ram,Qaseem,Software Engineer,SF
 Laks,Laks,Chief Technology Officer,SF
 Glynn,Laks,Principal Software Engineer,SF
 Raghav,Laks,Software Engineer,Canada

 An organizational chart is an ordered list where each employee is listed with his title and location formatted as  "Name [Title, Location]"
  The subordinates are printed out one tab further to the right from their manager.

 Example output:
 Laks [Chief Technology Officer, SF]
     Glynn [Principal Software Engineer, SF]
         DD [Senior Software Engineer, SF]
             Hari [Junior Software Engineer, India]
         Jin [Software Engineer, SF]
     Qaseem [Vice President of Engineering, SF]
         Dave [Software Engineer, Canada]
         Ram [Software Engineer, SF]
     Raghav [Software Engineer, Canada]

 Bonus:
 The employees in the list are ordered first by the number of their subordinates and then alphabetically by name. An employee's subordinates are then printed out just below them (with their respective subordinates printed in the same way) using the same ordering.
 */

    
    
    

}