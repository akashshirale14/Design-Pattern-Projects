package multiThreadedHS.threads;

import java.util.ArrayList;
import java.util.List;
import multiThreadedHS.util.FileProcessor;
import multiThreadedHS.util.Results;


public class ThreadWorker implements Runnable{
    public List<Integer>individualStore=new ArrayList<>();
    public String file;
    int[] arr;
    public Results result;
    int debugger;

    public ThreadWorker(Results r,String filename,int debugVal){
        debugger=debugVal;
        result=r;
        file=filename;
        if(debugger==4){
            System.out.println("In ThreadWorker Constructor");
        }
    }

    /**
     * This method is executed by the scheduler which is invoked by start() method
     * @return -This method returns void
     *
     */
    public void run(){
       readingFileData();
       //Now sort each individual thread data
        arr=new int[individualStore.size()];
        bubbleSort();
        result.addingLists(individualStore);

    }
    /**
     * Each thread reads its individual input file using this method
     * @return -This method returns void
     */
    public void readingFileData() {
        try {
            FileProcessor fp = new FileProcessor();
            String num = fp.readLine(file);
            while (num != null) {
                int ans = Integer.valueOf(num);
                individualStore.add(ans);
                num = fp.readLine(file);
            }
        }catch (Exception e){
            System.err.println("Error while reading a file");
            e.printStackTrace();
            System.exit(1);
        }
    }
    /**
     * This method sorts the individual elements of the thread using bubble sort
     * technique
     * @return - This method returns void
     *
     */
    public void bubbleSort(){
        if(debugger==1) {
            System.out.println("Thread data structure sorted");
        }
        for(int i=0;i<individualStore.size()-1;i++){
            for(int j=0;j<individualStore.size()-i-1;j++){
                int t1=individualStore.get(j);
                int t2=individualStore.get(j+1);
                if(t1 > t2){
                    int temp=t1;
                    int temp2=t2;
                    individualStore.add(j,t2);
                    individualStore.remove(j+1);
                    individualStore.add(j+1,t1);
                    individualStore.remove(j+2);
                }
            }
        }
    }



	
}