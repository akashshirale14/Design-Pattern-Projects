package multiThreadedHS.util;
import multiThreadedHS.util.Results;
import java.util.List;
import java.util.ArrayList;
import multiThreadedHS.util.Results;
public class MergeSort {

    public Results result;
    int debugger;

    public MergeSort(Results r,int debugVal) {
        debugger=debugVal;
        if(debugger==4){
            System.out.println("In HeapSort Constructor");
        }
        result = r;
    }
    /**
     * This method does the merge sorting on the data list
     * https://www.codexpedia.com/java/java-merge-sort-implementation/
     * @param List<Integer>-Takes the input as list stored i Results class
     * @return List<Integer>-This method returns the sorted list
     */
    public List<Integer> mergeSort(List<Integer> k) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int center;
        if (k.size() == 1) {
            return k;
        } else {
            center = k.size() / 2;

        for (int i = 0; i < center; i++) {
            left.add(k.get(i));
        }

        for (int i = center; i < k.size(); i++) {
            right.add(k.get(i));
        }

        left = mergeSort(left);
        right = mergeSort(right);

        merge(left, right, k);
    }
        return k;
}
    /**
     * This method merges the left and right sub tree.
     * https://www.codexpedia.com/java/java-merge-sort-implementation/
     * @param left-The left part of the list which is passed
     * @param right- The right part of the list which is passed
     * @param k- The list with the size of left+right
     * @return -This method returns void
     */
    public void merge(List<Integer>left,List<Integer>right,List<Integer>k){
        int leftIndex = 0;
        int rightIndex = 0;
        int kIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                k.set(kIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                k.set(kIndex, right.get(rightIndex));
                rightIndex++;
            }
            kIndex++;
        }
        List<Integer> rest=new ArrayList<>();
        int restIndex;
        if (leftIndex >= left.size()) {
            // The left ArrayList has been used up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }
        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            k.set(kIndex, rest.get(i));
            kIndex++;
        }
    }



    }