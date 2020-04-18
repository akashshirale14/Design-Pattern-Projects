package racingDrivers;

import racingDrivers.util.FileProcessor;
 import racingDrivers.driverStates.DriverContextClass;
 import racingDrivers.driverStates.DriverStateClass;
 import racingDrivers.util.Results;
import java.lang.Math;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class RaceContextClass {
	public static String s;
    public static String fi;
    public static String[] store_strings;
    public double arr[];
    public String current_state;
    public DriverContextClass[] dc;
    public DriverContextClass temp;
    public Map<Integer, String> hm;
   DriverStateClass ds;
    public static int minute;
    int debuggerVal;
    FileProcessor fp;
    List<String> ansSum;
    static int count;
     String[] s1;
     static String outPutFile;
     /**
      * It initialiZes the object of type RaceContextClass
      * @param k - It contains the path of the input.txt file
      * @param val- It contains the debuggerVal variable
      * 
      */
   public  RaceContextClass(String k,int val,String filename){
        fi=k;
        s="";
        current_state="";
        hm = new HashMap<>();
        minute=1;
        debuggerVal=val;
        if(debuggerVal==4){
            System.out.println("In RaceContextClass Constructor");
        }
        outPutFile=filename;
       ansSum=new ArrayList<>();
        count=0;
    }
   
   /**
    * Reads the input from the file
    * @param  - No parameters
    * @return void - This function returns void
    * 
    */
    public void readInput(){
    try{
        fp=new FileProcessor(debuggerVal);
        s=fp.readLine(fi);
        int num=Integer.parseInt(s);
         s1=new String[num];
        initializeobjDrivers(num,debuggerVal);
        assignDriverStates(hm,num);
        while(true){
            s=fp.readLine(fi);
            if(s==null){
                break;
            }else{
                store_strings=s.split(" ");
                arr=new double[store_strings.length];

                for(int i=0;i<store_strings.length;i++){
                    arr[i]=Double.parseDouble(store_strings[i]);
                    
                }
            }
            
            //Adding respective Distance to respective Driver
              inputToDriverContext();

               //References to Driver Class Objects:
            DriverContextClass anotherDc[]=new DriverContextClass[num];
            for(int k=0;k<num;k++){
                anotherDc[k]=dc[k];
               
            }
            //initialize all flags to be zero at each iteration
             for(int i=0;i<num;i++){
                anotherDc[i].flag=0;  
            }

             //Arranging according to the order and assigning respective position state again
            rankWise(num,anotherDc);

             if(debuggerVal==3) {
                for (int i = 0; i < num; i++) {   
                    s1[i] = dc[i].mindState;

                }
            }

             //Setting flags for same position
            settingFlagState(anotherDc, num);

            //Assigning the Dc mind state
            updateState(anotherDc,debuggerVal);

             if(debuggerVal==3) {
                for (int i = 0; i < num; i++) {   
                    if (s1[i] != dc[i].mindState) {
                        System.out.println("State of Driver changes at Driver Position : " + dc[i].position + " from " + s1[i] + " to " + dc[i].mindState);
                    }

                }
            }

             

             if(debuggerVal==2 || debuggerVal==1){
                deBugger(dc,debuggerVal);
            }

            if(debuggerVal==0){
               for(int i=0;i<dc.length;i++){
                   ansSum.add(dc[i].mindState);
               }
                ansSum.add("\n");
            }

        }
         Results r=new Results(outPutFile);
         int len=ansSum.size();
        /*for(int i=1;i<=dc.length+1;i++){
          ansSum.remove(len-i);
        }*/
        r.writeToFile(ansSum);
      }catch(Exception e){
        System.err.println("Error while reading file");
        e.printStackTrace();
        System.exit(1);
      }
    }
    /**
     * Initializes the object for each driver
     * @param num - It contains the number of drivers
     * @param debuggerVal - The debugger val received by command line
     * @return void - This function returns void
     * 
     */
     void initializeobjDrivers(int num,int debuggerVal){
        dc=new DriverContextClass[num];
        for(int i=0;i<num;i++){
            dc[i]=new DriverContextClass(debuggerVal);
            dc[i].position=i+1;
        }
    }
     /**
      * Arranging according to the order and assigning respective position state again
      * @param num- The number of Drivers
      * @param anotherDc -It is an array of type DriverContextClass and contains references to all drivers
      * @return-This function returns void
      */
     void rankWise(int num,DriverContextClass[] anotherDc){
     
        for(int i=0;i<num;i++){
            for(int j=i+1;j<num;j++){
                if(anotherDc[i].total_distance_travelled<anotherDc[j].total_distance_travelled){
                    temp=anotherDc[i];
                    anotherDc[i]=anotherDc[j];
                    anotherDc[j]=temp;
                }
            }
          //Placing their rank
            anotherDc[i].rank=i+1;       
            anotherDc[i].positionState=hm.get(anotherDc[i].rank);
        }
    }
     
     /**
      * Adding respective Distance to respective Driver
      * @param- No parameter used
      * @return-This function returns void
      */
     void inputToDriverContext(){
        for(int j=0;j<arr.length;j++){
            dc[j].allStateMethod(arr[j]);
            
        }
    }

     /**
      * Arranging according to the order and assigning respective position state again
      * @param num- The number of Drivers
      * @param hm -It is an hashmap which stores the States according to their position
      * @return-This function returns void
      */
     void assignDriverStates(Map hm,int num){
        int pos;
        int nearRound=(int)Math.round(0.3*num);
        int farRound=(int)Math.round(0.7*num);
        for(int i=0;i<num;i++){
           pos=i+1;
           if(pos<=nearRound){
               hm.put(pos,"LEADING");
           }else if((nearRound<pos)&&(pos<farRound)){
               hm.put(pos,"HOLDING_ON");
           }else{
               hm.put(pos,"LOSING");
           }
        }
    }

     /**
      * This function sets flag for drivers who are at the same position
      * @param num- The number of Drivers
      * @param anotherDc -It is an array of type DriverContextClass and contains references to all drivers
      * @return-This function returns void
      */
    void settingFlagState(DriverContextClass[] anotherDc, int num) {

        for (int i = 0; i < anotherDc.length-1; i++) {
            int j=i+1;
            if (Double.compare(anotherDc[i].total_distance_travelled,anotherDc[j].total_distance_travelled)==0) {
                anotherDc[i].flag=1;
                anotherDc[j].flag=1;
            }
        }

    }

    /**
     * Update the state of the driver
     * @param debuggerVal- The debugger val received by command line
     * @param another -It is an array of type DriverContextClass and contains references to all drivers
     * @return-This function returns void
     */
     void updateState(DriverContextClass[] another,int debuggerVal){
    	  ds=new DriverStateClass(debuggerVal);
     ds.setStateName(another,debuggerVal);

    }

     /**
      * Printing to Stdout using debuggerVal 
      * @param debuggerVal- The debugger val received by command line
      * @param dc -It is the original array of type DriverContextClass and contains objects of all drivers
      * @return-This function returns void
      */
    void deBugger(DriverContextClass[] dc,int debuggerVal){
            if (debuggerVal==2) {
                for (int i = 0; i < dc.length; i++) {
                    if(minute==1){
                        System.out.println("Driver Position : "+dc[i].position + " Total Distance Travelled till "+minute+" minute is : "+dc[i].total_distance_travelled);
                    }else{
                        System.out.println("Driver Position : "+dc[i].position + " Total Distance Travelled till "+minute+" minutes is : "+dc[i].total_distance_travelled);
                        
                    }
                }
                minute++;
            }
        else{
                if (debuggerVal==1) {
                    System.out.println("At " + minute + " minute");
                    System.out.print("Driver Position : ");
                    for (int i = 0; i < dc.length; i++) {
                        System.out.print(dc[i].position+" ");
                    }
                    System.out.println();
                    System.out.print("Driver Rank     : ");
                    for (int i = 0; i < dc.length; i++) {
                        System.out.print(dc[i].rank+" ");
                    }
                    System.out.println();
                    minute++;
                }
        }
    }
    
    public String toString(DriverContextClass dc[]){
    	for(int i=0;i<dc.length;i++) {
    		System.out.print("Driver Position : "+dc[i].position+" State of mind: "+dc[i].mindState);
    		System.out.println();
    	}
        return "This are current mind States";
       }
}