package myArrayList.util;
import myArrayList.util.FileDisplayInterface;
import myArrayList.util.StdoutDisplayInterface;
import java.util.LinkedList;
import java.util.List;
import java.io.FileWriter; 

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private List<String> stringList;
    private String sfile;
   private String std="";

   FileWriter fp;

   public Results(String s){
    	sfile=s;
    	stringList = new LinkedList<>();
    	
    }
   /**
     * Writes the output to the file 
     * https://www.javatpoint.com/java-filewriter-class
     * 
     */

	public void writeToFile(String ansSum){
	try{
	String ans="";	
	fp=new FileWriter(sfile);
     ans="The sum of all the values in the array list is:  "+ansSum;
     fp.write(ans);
     fp.close();
    }catch(Exception e){
 		System.out.println(e);
     }  
	}

    /**
     * Writes the Output to standard output
     *
     * 
     */

	public void writeToStdout(String st){
		for(int i=0;i<stringList.size();i++){
		System.out.println(stringList.get(i));
        System.out.println("\n");
    }
		
	}
	
	/**
     * Stores the results of the test cases as strings
     *
     * 
     */
	public void storeNewResult(String std){
		stringList.add(std);
	}


    public String toString(){
        String str="",ans="";
        for(int i=0;i<stringList.size();i++){
        if(i==0){
                ans=ans+"[ "+stringList.get(i)+", ";
                
            }
            else if(i==stringList.size()-1){
                 ans=ans+stringList.get(i)+" ]";
                 
              }
            else{
                ans=ans+stringList.get(i)+", ";
            }
    }
    return ans;
}
}