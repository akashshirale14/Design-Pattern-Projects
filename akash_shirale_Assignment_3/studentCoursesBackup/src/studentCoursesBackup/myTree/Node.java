package  studentCoursesBackup.myTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node implements SubjectI,ObserverI {
	/**
	 * The enum Operations is defined here with INSERT and DELETE constants
	 *
	 */
    public enum Operations{
        INSERT,DELETE
    }
	public int B_number;
	public Map<String,Integer> hm=new HashMap<>();
	public List<Node> listners_list=new ArrayList<>();
	public Node left;
	public Node right;
	public static int debug_val;


	public Node(int key,String course,int debugger){
		debug_val=debugger;
		if(debugger==4){
			System.out.println("In Node Constructor");
		}
	    B_number=key;
	    hm.put(course,1);

    }

	/**
	 * This method call adds the backup node references to the original node
	 * @param n- the backup node which is added as reference
	 * @return -This method returns void
	 *
	 */
	public void add(Node n){
		listners_list.add(n);
	}

	/**
	 * It calls all references and run the update method of them to
	 * update the course by the B-number for addition or deletion
	 * @param listners_list- the list which stores references of backup nodes
	 * @param course-Enter the new course added by that respective B-number
	 * @param myvar-It is an enum which stores INSERT or DELETE value
	 * @return -This method returns void
	 *
	 */
	public void notifyAll(List listners_list,String course,Operations myvar){
            Node k;
            for (int i = 0; i < listners_list.size(); i++) {
                //System.out.println("Here notify");
                k = (Node) listners_list.get(i);

                k.update(course, myvar,i);
            }
	}


	/**
	 * This method updates the course in all backup nodes for insert and delete operations
	 * @param course-Enter the new course added by that respective B-number
	 * @param myvar-It is an enum which stores INSERT or DELETE value
	 * @param i - It is to denoted which backup tree is currented being updated
	 * @return - This method returns void
	 */
	public void update(String course,Operations myvar,int i){
        if(myvar==Operations.INSERT) {
			if(debug_val==3){
				System.out.println("Course "+course+" added to backup tree "+(i+1));
			}
            hm.put(course, 1);
        }else{
			if(debug_val==2){
				System.out.println("Course "+course+" removed from backup tree "+(i+1));
			}
            hm.remove(course);
        }
	}
	/**
	 * It is a toString method and prints information about current node
	 * @return -It returns a String
	 *
	 */
	public String toString() {
		System.out.println("Information about this node: ");
		System.out.println("Bnumber: "+B_number);
		System.out.println("Refernces to this node: ");
		for(int i=0;i<listners_list.size();i++){
			System.out.print(listners_list.get(i)+ " ");
		}
		return "In Node Class";
	}

}
