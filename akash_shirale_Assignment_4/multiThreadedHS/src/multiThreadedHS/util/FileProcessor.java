package multiThreadedHS.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor{

public int lineNumber = 0;
        String ans,temp;
        FileReader file ;
/**
 * This method reads file input line by line
 * It is called by ThreadWorker class.
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
        /**
         * It is a toString method
         * @return String-Returns the string
         *
         * */
        public String toString(){
                 return "File is being processed";
                }
          }