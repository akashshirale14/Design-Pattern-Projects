
package multiThreadedHS.util;

public class MyLogger{

    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime a new thread is created]
      DEBUG_VALUE=2 [Print to stdout everytime the data is entered into combined List ]
      DEBUG_VALUE=1 [Print to stdout everytime a thread sorts its own datastructure]
      DEBUG_VALUE=0 [No output should be printed from the applicatio to stdout. It is ok to write to the output file though" ]
    */

    public static enum DebugLevel {RELEASE, IN_THREADWORKER, IN_RESULTS, IN_THREAD, CONSTRUCTOR
    };

    private static DebugLevel debugLevel;
    /**
     * This method sets the particular value of enum based on debuggerValue
     * @param levelIn-takes the debuggerValue as input
     * @return -This method returns void
     *
     */
    public static void setDebugValue (int levelIn) {
        switch (levelIn) {
            case 4: debugLevel = DebugLevel.CONSTRUCTOR;
                MyLogger.setDebugValue(debugLevel);
                MyLogger.writeMessage("Printing Constructors :",debugLevel); break;
            case 3:debugLevel = DebugLevel.IN_THREAD;
                MyLogger.setDebugValue(debugLevel);
                MyLogger.writeMessage("Calls everytime a thread is created :",debugLevel); break;
            case 2:debugLevel = DebugLevel.IN_RESULTS;
                MyLogger.setDebugValue(debugLevel);
                MyLogger.writeMessage("Calls everytime thread puts its data into the main list :",debugLevel); break;
            case 1:debugLevel = DebugLevel.IN_THREADWORKER;
                MyLogger.setDebugValue(debugLevel);
                MyLogger.writeMessage("Calls everytime individual thread sorts its data structure :",debugLevel); break;
            case 0: debugLevel = DebugLevel.RELEASE; break;
        }
    }
    /**
     * This methods  sets enum debugLevel value
     * @param levelIn -It takes input value and sets it.
     * @return -This method returns void
     *
     */
    public static void setDebugValue (DebugLevel levelIn) {
        debugLevel = levelIn;
    }
    /**
     * This methods prints out Stdout Display
     * @param message- String input which is given by setDebugValue
     * @param levelIn -It takes input value and sets it.
     * @return -This method returns void
     *
     */
    public static void writeMessage (String  message  ,
                                     DebugLevel levelIn ) {
        if (levelIn == debugLevel)
            System.out.println(message);
    }
    /**
     * It is a toString method
     * @return- This method returns String
     */
    public String toString() {
        return "Debug Level is " + debugLevel;
    }
}
