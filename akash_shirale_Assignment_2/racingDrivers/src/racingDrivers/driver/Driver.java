
package racingDrivers.driver;
import racingDrivers.util.MyLogger;

import racingDrivers.RaceContextClass;   
/**
 * @author Akash Shirale
 *
 */
    
    public class Driver {
    	/**
         * It is the main method
         * @param args-It contains the command line arguments
         * 
         */
    	public static int a1;
    	public static float f;
	public static void main(String[] args) {
		try{
	    /*
	     * As the build.xml specifies the arguments as argX, in case the
	     * argument value is not given java takes the default value specified in
	     * build.xml. To avoid that, below condition is used
	     */
		 
		 int a=Integer.parseInt(args[2]);
		
	   if ( (args.length != 3) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
		    
		    System.err.println("Error: Incorrect number of arguments. Program accepts 3 argumnets.");
		    System.exit(0);
	    }   
	  /* if(f!=a) {
		   System.err.println("3rd argument must be an integer between 0 and 4 including");
		   System.exit(0);
	   }*/
	  if(a<0 || a>4) {
		   
		   System.err.println("3rd argument must be an integer between 0 and 4 including");
		   System.exit(0);
	   }
	    
	    //System.out.println("Hello World! Lets get started with the assignment");
	    //System.out.println("File Input");
	   	String n=args[0];
	   	int debugger_value=a;
        MyLogger.setDebugValue(debugger_value);
        RaceContextClass rc=new RaceContextClass(n,debugger_value,args[1]);
        rc.readInput();

	}catch(Exception e) {
		System.err.println("The inputs are Wrong.Please Enter Correct Inputs");
		System.exit(1);
	}

	}  // end public static void main
	
	public String toString(int a1){
		String s="This is Driver Class ";
		 s=s+"and debug value is "+String.valueOf(a1);
		return s;
	}
    }  // end public class Driver