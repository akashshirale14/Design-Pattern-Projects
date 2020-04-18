package studentCoursesBackup.util;

import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface,StdoutDisplayInterface {

    private int debugger;
    private String sfile;
	public Results(String f,int val){
	    debugger=val;
        if(debugger==4){
            System.out.println("In Results Constructor");
        }
	   sfile=f;
    }

    /**
     * It opens the output file and prints data to the file.
     * @param s-It takes the whole output as a string
     * @return -This method returns void
     *
     */
   public void writeToFile(String s){
       try{
           FileWriter fp=new FileWriter(sfile);
           fp.write(s);
           fp.close();
       }catch(IOException e){
           System.err.println("Error while writing to a file");
           e.printStackTrace();
           System.exit(1);
       }
   }

    /**
     * It prints the output to stdout
     * @param st-It takes the whole output as a string
     * @return -This method returns void
     *
     */
    public void writeToStdout(String st) {
        System.out.println(st);
	}

    /**
     * It is a toString method,it prints the current output file name
     * @return -It returns a String
     *
     */
    public String toString() {
        System.out.println("Output file currently operated :"+sfile);
        return "Results class";
    }

}
