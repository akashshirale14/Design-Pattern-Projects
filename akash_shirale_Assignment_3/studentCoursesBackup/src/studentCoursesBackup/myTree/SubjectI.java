package studentCoursesBackup.myTree;
import java.util.List;
public interface SubjectI {
    /**
     * This method is implemented in Node Class
     * @param n- the backup node which is added as reference
     * @return -This method returns void
     *
     */
	 void  add(Node n);
    /**
     * This method is implemented in Node Class
     * @param listners_list- the list which stores references of backup nodes
     * @param course-Enter the new course added by that respective B-number
     * @param myvar-It is an enum which stores INSERT or DELETE value
     * @return -This method returns void
     *
     */
     void notifyAll(List listners_list, String course, Node.Operations myvar);
}
