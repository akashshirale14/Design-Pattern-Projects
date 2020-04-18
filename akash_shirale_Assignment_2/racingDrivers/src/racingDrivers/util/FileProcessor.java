package racingDrivers.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class FileProcessor {
	public int debugger;
	/**
     * It is an StdOut interface and it contains one method
     * It is implemented by Results class
     * @param val- Takes input as debuggerVal
     * 
     * 
     */
	public FileProcessor(int val){
        debugger=val;
        if(debugger==4){
            System.out.println("In FileProcessor Constructor");
        }
    }
 public static int lineNumber = 0;
    String ans,temp;
    FileReader file ;
    /**
     * It is an StdOut interface and it contains one method
     * It is implemented by Results class
     * @param s- String input as file name
     * @return String-Returns each line on the file
     * 
     */
    public String readLine(String s){
        try {
            FileReader file = new FileReader(s);
            BufferedReader br = new BufferedReader(file);

            for(int i=0;i<lineNumber;i++){
                temp=br.readLine();
            }
            ans=br.readLine();
            lineNumber++;

        }catch (IOException x){
            System.err.println("IO exception occured while reading File");
            x.printStackTrace();
            System.exit(1);
        }

        return ans;
    }
    
    public String toString(){
        return "File is being processed";
       }
}
