package racingDrivers.util;
public class MyLogger {
    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime the state is changed]
      DEBUG_VALUE=2 [Print to stdout the total distance travelled by each driver till that time according to their initial position]
      DEBUG_VALUE=1 [Print to stdout position of driver and its rank in that minute]
      DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]
    */
	/**
     * the enum is defined
     * 
     */
    public static enum DebugLevel {RELEASE, FROM_RESULTS, IN_RESULTS, IN_RUN, CONSTRUCTOR
    };

    private static DebugLevel debugLevel;

    /**
     * Takes the input and calls the respective case
     * @param levelIn - Takes the integer as input
     * @return void -This function returns void
     */
    public static void setDebugValue (int levelIn) {
        switch (levelIn) {
            case 4: debugLevel = DebugLevel.CONSTRUCTOR;
                MyLogger.setDebugValue(debugLevel);
                MyLogger.writeMessage("Printing Constructors :",debugLevel); break;
            case 3: debugLevel = DebugLevel.IN_RUN;
                MyLogger.setDebugValue(debugLevel);
                MyLogger.writeMessage("Printing Everytime the State is Changed :",debugLevel); break;
            case 2: debugLevel = DebugLevel.IN_RESULTS;
                MyLogger.setDebugValue(debugLevel);
                MyLogger.writeMessage("Printing Driver Position and their Rank :  ",debugLevel); break;
            case 1: debugLevel = DebugLevel.FROM_RESULTS;
                MyLogger.setDebugValue(debugLevel);
                MyLogger.writeMessage("Printing Distance Travelled till that point : ",debugLevel); break;
            case 0: debugLevel = DebugLevel.RELEASE;
                MyLogger.setDebugValue(debugLevel);
                break;

        }
    }
    /**
     * This function sets the levelIn value to type Debuglevel
     * @param levelIn - It is of type DebugLevel
     * @return void -This function returns void
     */
    public static void setDebugValue (DebugLevel levelIn) {
        debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String  message  ,
                                     DebugLevel levelIn ) {
        if (levelIn == debugLevel)
            System.out.println(message);
    }

    /**
     * @return String-This function returns string
     */
    public String toString() {
        return "Debug Level is " + debugLevel;
    }
}
