package myArrayList.util;
import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
 public static int lineNumber = 0;
    String ans,temp;
    FileReader file ;
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
               System.out.println("IO exception occured");
           }

           return ans;
        }

     
     public String toString(){
      return "File is being processed";
     }

    }
