package studentCoursesBackup.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class FileProcessor {
    FileReader file ;
    public static int lineNumber;
    String temp,ans;
    public int debugger;
    public FileProcessor(int val){
        lineNumber = 0;
        temp="";
        ans="";
        debugger=val;
        if(debugger==4){
            System.out.println("In FileProcessor Constructor");
        }

    }
    /**
     * It helps to read file line by line
     * @param s- String input as file name
     * @return String-Returns each line on the file
     *
     */
    public String readLine(String s){
        try{
            FileReader file = new FileReader(s);
            BufferedReader br = new BufferedReader(file);

            for(int i=0;i<lineNumber;i++){
                temp=br.readLine();
            }
            ans=br.readLine();
            lineNumber++;


        }catch(IOException x){
            System.err.println("IO exception occured while reading File");
            x.printStackTrace();
            System.exit(1);
        }

        return ans;
    }

    /**
     * It is a toString method
     * @return -It returns a String
     *
     */
    public String toString(){
        return "File is being processed";
    }






}
