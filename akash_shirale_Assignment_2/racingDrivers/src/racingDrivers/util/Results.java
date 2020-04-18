package racingDrivers.util;

import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import racingDrivers.util.FileDisplayInterface;
import racingDrivers.util.StdoutDisplayInterface;
public class Results implements FileDisplayInterface,StdoutDisplayInterface{
   private List<String> stringList;
    private String sfile;
    

    FileWriter fp;
    /**
     * 
     * It initializes the Result object
     * @param s - It contains the location of the output file
     * 
     * 
     */
    public Results(String s) {
        sfile = s;
       stringList = new LinkedList<>();

    }

    /**
     * Writes the output to the file
     * https://www.javatpoint.com/java-filewriter-class
     * @param ansSum - It contains the state of each driver
     * @return void - This function returns void
     * 
     */
    public void writeToFile(List ansSum) {
        try {
            
            fp = new FileWriter(sfile);

            for(int i=0;i<ansSum.size();i++) {
                    fp.write(ansSum.get(i) + " ");
            }
            fp.close();
        } catch (Exception e) {
            System.err.println("Error while writing to a file");
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    /**
     * Writes the output to the Stdout
     * @param st - Takes the string as input
     * @return void -This function returns void
     */
    public void writeToStdout(String st){
		for(int i=0;i<stringList.size();i++){
		System.out.println(stringList.get(i));
        System.out.println("\n");
    }
   }
    
    public String toString(){
        return "In Results Class";
       }
}
