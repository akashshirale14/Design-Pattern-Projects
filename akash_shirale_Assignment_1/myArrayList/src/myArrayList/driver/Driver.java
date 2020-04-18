package myArrayList.driver;
import myArrayList.util.FileProcessor;
import myArrayList.MyArrayList;
import myArrayList.util.Results;
import myArrayList.test.MyArrayListTest;

/**
 * @author Akash Shirale
 *
 */
public class Driver {
      static String arg0;
      static String arg1;
    Driver(){
    	 arg0="";
    	 arg1="";
    }
	public static void main(String[] args) {
 		 String s="";
        int num;
        String st="";
        boolean k=true;
	
		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		
		if (args.length !=2 || args[0].equals("${arg0}") || args[1].equals("${arg1}") ) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 2 argumnets.");
			System.exit(0);
		}

		MyArrayList myArrayList=new MyArrayList();  //myArrayList instance

		FileProcessor fp=new FileProcessor();
		arg0=args[0];
        s=fp.readLine(args[0]);
        while(s!=null){
            num=Integer.parseInt(s);
            myArrayList.insertSorted(num);
            s=fp.readLine(args[0]);
        }
        
        arg1=args[1];
		Results results=new Results(args[1]);
		
		String ansSum=String.valueOf(myArrayList.sum());
		results.writeToFile(ansSum);
       //Making Array empty to check the test cases
       for(int i=0;i<10000;i++){
       	myArrayList.removeValue(i);
       }

		MyArrayListTest m=new MyArrayListTest();
		m.testMe(myArrayList,results);

		results.writeToStdout(st);


	}

	public String toString(){
		MyArrayList myArrayList=new MyArrayList();
		System.out.println("Present Array:");
		return myArrayList.toString();
	}
}
