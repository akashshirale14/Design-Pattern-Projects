//MyArrayListTest.java
package myArrayList.test;
import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest{
     /**
     * Calls the testcase methods to check operations on array 
     *
     * 
     */
     public void testMe(MyArrayList myArrayList, Results results){
     numInsert(myArrayList,results,23);
     numInsert(myArrayList,results,78);    
     numInsert(myArrayList,results,32);
     numInsert(myArrayList,results,2);
     numInsert(myArrayList,results,2);
     checkSum(myArrayList,results);
     checkSize(myArrayList,results);
     checkIndexof(myArrayList,results);
     checkIndexTest(myArrayList,results);
     checkRemoveValues(myArrayList,results,2);
     checkTestRemoveValues(myArrayList,results,666);
     checkCompact(myArrayList,results);
     reSizeTest(myArrayList,results);
	insertNegativeNumber(myArrayList,results,-56);
	checkRemoveValues(myArrayList,results,78);
	checkCompact(myArrayList,results);
     }
      /**
	   * Check if the arraysize increases by 1 when you insert 1 element into the array
	   *
	   * @param myArrayList
	   * @param results
	   * @param val
	   */
    public void numInsert(MyArrayList myArrayList,Results results,int val){
          int currentsize=myArrayList.size();
          myArrayList.insertSorted(val);
          int newsize=myArrayList.size();
          if(newsize==currentsize+1){
          	results.storeNewResult("numInsertCase: PASSED");
          }
          else{
          	results.storeNewResult("numInsertCase: FAILED");
          }
    }
        
     /**
	 * Checking whether the sum of the array is correct or not,by inserting those variables in function
	 *
	 * @param myArrayList
	 * @param results
	 */   
     public void checkSum(MyArrayList myArrayList,Results results){
       int a=23;
       int b=78;
       int c=32;
       int d=2;
       int e=2;
       int finalsum=myArrayList.sum();
       if(finalsum==a+b+c+d+e){
       	
        results.storeNewResult("checkSumCase: PASSED");
       }
       else{
       	
       	results.storeNewResult("checkSumCase: FAILED");
       }
     }


    /**
	 * add 4 elements in the array,and check whether the size increases by 4 or not 
	 *
	 * @param myArrayList
	 * @param results
	 */

     public void checkSize(MyArrayList myArrayList,Results results){
      int prevsize=myArrayList.size();
       myArrayList.insertSorted(23);
       myArrayList.insertSorted(78);
       myArrayList.insertSorted(32);
       myArrayList.insertSorted(2);
       int totalsize=myArrayList.size();
       if(totalsize==prevsize+4){
       	
			results.storeNewResult("checkSizeCase: PASSED");
       }
       else{
       		results.storeNewResult("checkSizeCase: FAILED");
       }

     }


    /**
	 * Check whether the number is at correct index position in the array or not
	 *
	 * @param myArrayList
	 * @param results
	 */

     public void checkIndexof(MyArrayList myArrayList, Results results){
           //checking value of element present
           if(myArrayList.indexOf(32)!=3){
           		results.storeNewResult("checkIndexofCase: PASSED");
           }else{
           	results.storeNewResult("checkIndexofCase: FAILED");
           }
     }


/**
	 * Checking the index value of the number not present in the array
	 *
	 * @param myArrayList
	 * @param results
	 */
   public void checkIndexTest(MyArrayList myArrayList, Results results){
   	//checking value of element not present
    	if(myArrayList.indexOf(555)==-1){
    		
    		results.storeNewResult("checkIndexTestCase: PASSED");
    	}else{
    		results.storeNewResult("checkIndexTestCase: FAILED");
    	}
    }
     
     /**
	 *Checkes whether values are being removed correctly or not
	 *
	 * @param myArrayList
	 * @param results
	 * @param value
	 */
     public void checkRemoveValues(MyArrayList myArrayList,Results results,int value){
         //initial size
         int currentsize=myArrayList.size();
         //removing the element
          myArrayList.removeValue(value);
          //dreceased size after removing element
          int newsize=myArrayList.size();
          if(newsize<currentsize){
          	
			results.storeNewResult("checkRemoveValuesCase: PASSED");
    	}else{
    		results.storeNewResult("checkRemoveValuesCase: FAILED");
    	}

     }

/**
	 * The number to be removed in not present still checking remove occurs or not
	 *
	 * @param myArrayList
	 * @param results
	 * @param value
	 */
     public void checkTestRemoveValues(MyArrayList myArrayList,Results results,int value){
     	int currentsize=myArrayList.size();
          myArrayList.removeValue(value);
          int newsize=myArrayList.size();
          if(currentsize==newsize){
          	
          	results.storeNewResult("checkTestRemoveValuesCase: PASSED");
          }else{
          	results.storeNewResult("insertNegativeNumberCase: FAILED");
          }
     }

    /**
	 * Reduces the array,as it ignores the -1 values
	 *
	 * @param myArrayList
	 * @param results
	 */

	public void checkCompact(MyArrayList myArrayList,Results results){
		int currentsize=myArrayList.size();
          myArrayList.compact();
          int newsize=myArrayList.size();
          if(currentsize==newsize){
          	
          	results.storeNewResult("checkCompactCase: PASSED");
          }else{
          	results.storeNewResult("checkCompactCase: FAILED");
          }
     }

/**
	 * Check whether the array gets resized after increasing elements
	 *
	 * @param myArrayList
	 * @param results
	 */
     public void reSizeTest(MyArrayList myArrayList,Results results){
     	int currentsize=myArrayList.size();
     	for(int i=1;i<=32;i++){
			myArrayList.insertSorted(i);
     	}
     	 int newsize=myArrayList.size();
     	 if(currentsize + 32==newsize){
     	 	
          	results.storeNewResult("reSizeTestCase : PASSED");
          }else{
          	results.storeNewResult("reSizeTestCase : FAILED");
          }

     }

   /**
	 * Check whether the negative number gets inserted or not in the array 
	 *
	 * @param myArrayList
	 * @param results
	 * @param value
	 */
     public void insertNegativeNumber(MyArrayList myArrayList,Results results,int value){
     	int currentsize=myArrayList.size();
          myArrayList.insertSorted(value);
          int newsize=myArrayList.size();
          if(currentsize==newsize){
          	
			results.storeNewResult("insertNegativeNumberCase: PASSED");
          }else{
          	results.storeNewResult("insertNegativeNumberCase: FAILED");
          }

     }

}