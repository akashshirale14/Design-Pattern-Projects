package racingDrivers.driverStates;

public class DriverStateClass implements DriverStateI{
	    int data;
 /**
  * Initializes DriverStateClass object
  * @param val- input as debuggerVal
  * 
  * 
  */
 public DriverStateClass(int val){
    data=val;
    if(val==4){
        System.out.println("In DriverState Constructor");
    }
}
 
 /**
  * It calls the DriverContextClass method to set state of each driver
  * @param data- input as debuggerVal
  * @param dcc- Array containing references to anotherDc[]
  * @return void- returns void
  * 
  */
    public void setStateName(DriverContextClass[] dcc,int data){
        DriverContextClass d=new DriverContextClass(data);
        d.setState(dcc);
    }
    
    
    public String toString(){
        return "In DriverStateClass";
       }
}