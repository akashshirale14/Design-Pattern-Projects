package studentCoursesBackup.myTree;

public interface ObserverI {
    /**
     * This method is implemented by Node Class
     * @param course-Enter the new course added by that respective B-number
     * @param myvar-Tells which operation to be performed on backup nodes
     * @param a-Tells which backup tree is currently being operated
     * @return -This method returns void
     */
    void update(String course, Node.Operations myvar,int a);

}
