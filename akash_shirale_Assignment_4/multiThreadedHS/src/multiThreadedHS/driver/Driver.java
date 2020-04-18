package multiThreadedHS.driver;
import multiThreadedHS.threads.ThreadWorker;
import multiThreadedHS.util.Results;
import multiThreadedHS.util.MergeSort;
import multiThreadedHS.util.MyLogger;
import java.util.List;
public class Driver{
	/**
	 * It is the main method
	 * @param String[]- It takes command line arguments as inputs
	 * @return -This method returns void
	 *
	 * */
	public static void main(String[] args){

		int argumentLength=args.length;

		int numberOfInputFiles=Integer.parseInt(args[0]);

		int actualLengthNeeded=4+(numberOfInputFiles-1);
		int debuggerValue=Integer.parseInt(args[argumentLength-1]);


		//Input validation check
		if(argumentLength!= actualLengthNeeded){
			System.out.println("Wrong input arguments");
			System.exit(1);
		}
		MyLogger.setDebugValue(debuggerValue);
		Results result=new Results(args[argumentLength-2],debuggerValue);
		//Calling threads one by one
		for(int i=1;i<=numberOfInputFiles;i++){
			String file=args[i];
			ThreadWorker tw=new ThreadWorker(result,file,debuggerValue);
			Thread thread=new Thread(tw);
			if(debuggerValue==3){
				System.out.println("Thread "+i+" started");
			}
			thread.start();
			try {
				thread.join();
			}catch (InterruptedException e) {
				System.out.println("Error in thread join.");
				e.printStackTrace();
				System.exit(0);
			}
		}
		//HeapSort object created
		result.printList(); //dummy method
		MergeSort hp=new MergeSort(result,debuggerValue);
		List<Integer> f1=result.finalList;
		result.finalList=hp.mergeSort(f1);
		if(debuggerValue==0) {
			result.writeToFile(result.finalList);
		}


		
	}

}