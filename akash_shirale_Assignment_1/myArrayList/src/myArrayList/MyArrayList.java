//MyArrayList.java
package myArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import myArrayList.util.FileProcessor;
import myArrayList.test.MyArrayListTest;


public class MyArrayList{

    private static int[] arr1;
    private List<Integer> orderlist;
    public static int indexInput;
    private static int[] arr2;
    /**
     * Initializes the linked list data structure and also the arrays
     *
     * 
     */ 
   public  MyArrayList() {
        arr1 = new int[50];
        arr2=new int[50];
        for(int i=0;i<arr1.length;i++){
            arr1[i]=50000;
            arr2[i]=50000;
        }
        orderlist = new LinkedList<>();
        indexInput=0;
    }

    /**
     * insertsorted method inserts new element in array
     *
     * @param newValue
     */
   public void insertSorted(int newValue){
     if(newValue >=0){ 
      if(indexInput==arr1.length){
        //adding element by increasing the size of the array
        arr2=new int[arr1.length+25];
        for(int a=arr1.length;a<arr2.length; a++){
            arr2[a]=50000;
        }
        for(int i=0;i<arr1.length;i++){
            arr2[i]=arr1[i];
        }
        arr2[indexInput]=newValue;
        arr1=arr2;
        indexInput++;
      }else{
      //adding element without increasing the size of the array  
      arr1[indexInput]=newValue;
      //Sorting the array using Arrays.sort method
      Arrays.sort(arr1); 
      orderlist.add(newValue);
      indexInput++;
      } 
     }  
    }

   /**
     * Prints the contents according to the order of insertion in the array
     *
     */
    public void printInsertionOrder() {
        //Printing all the contents of the linked
        for (int i = 0; i < orderlist.size(); i++) {
            System.out.println(orderlist.get(i));
        }
    }

    /**
     *  remove all occurence of that value from array
     *
     * @param value
     */
    public void removeValue(int value) {
        int maxVal = 50000;
        //Finding that value and setting it to 50000
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == value) {
                arr1[i] = maxVal;
            }
        }

        Arrays.sort(arr1);
        //Storing the index at which next insertion will be performed
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]==-1){
                indexInput=i;
                break;
            }
        }

        //remove that respective value from linked list
        for (int i = 0; i < orderlist.size(); i++) {
            if (value == orderlist.get(i)) {
                orderlist.remove(i);
            }
        }
    }

 /**
     * Returns the reduced array after removing empty buckets
     *
     * 
     */
    public void compact() {     
        int index = 0;
        //Finds the first index at which element is 50000
        for (int j = 0; j < arr1.length; j++) {
            if (arr1[j] == -1 || arr1[j]==50000) {
                index = j;
                break;
            }
        }
       // Creates the new array with the new length
        int[] arr2 = new int[index];
        for (int k = 0; k < index; k++) {
            arr2[k] = arr1[k];
        }
        //Changes the references of the original array
        arr1 = arr2;
        indexInput=arr1.length;
    }

    /**
     * Returns the index of the value in the array 
     *
     * @param value
     */
    public int indexOf(int value) {
        //When the value is found in the array,it returns the index
        for (int j = 0; j < arr1.length; j++) {
            if (arr1[j] == value) {
                return j;
            }
        }
        return -1;
    }

   /**
     * Returns the size of the array 
     *
     * 
     */
    public int size() {
        int count = 0;
        //Counts all numbers which are present in the array except -1 and 50000
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 50000) {
                return count;
            }
            count++;
        }
        return count;
    }

    /**
     * Returns the sum of all the elements in the array
     *
     */
    public int sum() {
        int sum=0;
        //Adds each element one by one and produces sum
        for (int i = 0; i < arr1.length; i++) {

            if (arr1[i] == -1 || arr1[i]==50000) {
                return sum;
            }
            sum = sum + arr1[i];
        }
        return sum;
    }


   /**
     * ToString method prints the contents of the array in a pretty manner 
     *
     *
     */ 
    public String toString(){
        String str="",ans="";
        for(int i=0;i<arr1.length;i++){
            if(i==0){
                ans=ans+"[ "+arr1[i]+", ";
                
            }
            else if(i==arr1.length-1){
                 ans=ans+String.valueOf(arr1[i])+" ]";
                 
              }
            else{
                ans=ans+String.valueOf(arr1[i])+", ";
            }
           
    }
     return ans;
}

}