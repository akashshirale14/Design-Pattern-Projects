package multiThreadedHS.util;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import multiThreadedHS.util.FileDisplayInterface;
import multiThreadedHS.util.StdoutDisplayInterface;
public class Results implements FileDisplayInterface,StdoutDisplayInterface{
public List<Integer> finalList=new ArrayList<>();
private String sfile;
    FileWriter fp;
    int debugger;

    public Results(String s,int debugVal){
        debugger=debugVal;
        if(debugger==4){
            System.out.println("In Results Constructor");
        }
        sfile=s;
    }
    /**
     * It is a synchronized method which adds individual thread list
     * to the main list
     * @param List<Integer> -This method takes list as input
     * @return -This method returns void
     */
    public synchronized void addingLists(List<Integer> k){
        if (debugger==2){
            System.out.println("Combining this thread list into main list ");
        }
        int listSize=k.size();
        for(int i=0;i<listSize;i++){
            int num=k.get(i);
            finalList.add(num);
        }

    }
    /**
     * This method prints the finalList to the output file
     * @param List-This method takes list as input
     * @return - This method returns void
     *
     */
    public void writeToFile(List ansSum){
        try {
            fp = new FileWriter(sfile);
            for(int i=0;i<ansSum.size();i++) {
                fp.write(ansSum.get(i) + " ");
                fp.write("\n");
            }
            fp.close();
        }catch (Exception e){
            System.err.println("Error while writing to a file");
            e.printStackTrace();
            System.exit(1);
        }
    }
    /**
     * This method prints the result to standard output
     * @param st-It takes string as input
     * @return- This method returns void
     *
     */
    public void writeToStdout(String st){
        for(int i=0;i<finalList.size();i++){
            System.out.println(finalList.get(i));
            System.out.println("\n");
        }
    }
    /**
     * It is a toString method
     * @return String-Returns the string
     *
     * */
    public String toString(){
        return "In Results Class";
    }

    public void printList(){
        System.out.println(finalList);
    }

}