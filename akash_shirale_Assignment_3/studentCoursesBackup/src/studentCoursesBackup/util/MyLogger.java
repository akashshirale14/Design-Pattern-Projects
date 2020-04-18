
package studentCoursesBackup.util;

public class MyLogger{

    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime a new course added to a Bnumber]
      DEBUG_VALUE=2 [Print to stdout everytime a course is deleted from a Bnumber ]
      DEBUG_VALUE=1 [Print to stdout everytime a course is not available for deletion]
      DEBUG_VALUE=0 [No output should be printed from the applicatio to stdout. It is ok to write to the output file though" ]
    */

    public static enum DebugLevel {RELEASE, FROM_RESULTS, IN_RESULTS, IN_RUN, CONSTRUCTOR
                                   };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	  case 4: debugLevel = DebugLevel.CONSTRUCTOR;
	      MyLogger.setDebugValue(debugLevel);
          MyLogger.writeMessage("Printing Constructors :",debugLevel); break;
        case 3:debugLevel = DebugLevel.IN_RUN;
            MyLogger.setDebugValue(debugLevel);
            MyLogger.writeMessage("New Courses added to a Bnumber :",debugLevel); break;
        case 2:debugLevel = DebugLevel.IN_RESULTS;
            MyLogger.setDebugValue(debugLevel);
            MyLogger.writeMessage("Courses deleted from a Bnumber :",debugLevel); break;
        case 1:debugLevel = DebugLevel.FROM_RESULTS;
            MyLogger.setDebugValue(debugLevel);
            MyLogger.writeMessage("Courses not available for deletion from a Bnumber :",debugLevel); break;
	  case 0: debugLevel = DebugLevel.RELEASE; break;
	}
    }

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
	 * @return String
	 */
    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
