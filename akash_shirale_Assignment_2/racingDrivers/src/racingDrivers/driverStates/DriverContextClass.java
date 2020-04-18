package racingDrivers.driverStates;
import racingDrivers.driverStates.HelperClass;
public class DriverContextClass implements DriverContextI{
	 public String present_state;
    public Double total_distance_travelled;
    public int position;
    public int rank;
    public String positionState;
    public String mindState;
    public int flag;
    /**
     * It creates an object of DriverContextClass
     * @param val-debuggerVal
     * 
     */
    public DriverContextClass(int val){
        present_state="HOLDING_ON";
        total_distance_travelled=0.0;
        rank=0;
        positionState="";
        mindState = "RECKLESS";
        flag = 0;
        if(val==4){
            System.out.println("In DriverContextClass Constructor");
        }
    }
    /**
     * Adds each distance to that driver depending on its state
     * @param d- It is the corresponding distance each driver has travelled
     * @return Nothing- the return type is void
     */
    public void allStateMethod(Double d) {
        if (present_state == "HOLDING_ON") {
            total_distance_travelled += HelperClass.addingMethodForHoldingOn(d);
        }else if(present_state=="LEADING"){
            total_distance_travelled += HelperClass.addingMethodForLeading(d);
        }else{
            total_distance_travelled += HelperClass.addingMethodForLosing(d);
        }
    }
    /**
     * It sets the state of the driver in its object data member mindState
     * @param dcc- It is an array of type DriverContextClass which holds references to initial objects
     * @return Nothing- the return type is void
     */
    public static void setState(DriverContextClass[] dcc) {
        for (int i = 0; i < dcc.length; i++) {
            if (dcc[i].flag == 1) {
                dcc[i].mindState = "RECKLESS";
            } else {
                if (dcc[i].positionState == "HOLDING_ON") {
                    dcc[i].mindState = "CALCULATIVE";
                }
                if (dcc[i].positionState == "LEADING") {
                    dcc[i].mindState = "CONFIDENT";
                }
                if(dcc[i].positionState == "LOSING"){
                    dcc[i].mindState = "RECKLESS";
                }

            }
        }
    }
    
    public String toString(){
        return "In DriverContextClass";
       }

}