
package studentCoursesBackup.driver;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

/**
 * @author Akash Shirale
 *
 */
    
    public class Driver {
    public static String[] readAns = new String[2];
    static int debugger_val;

    public static void main(String[] args) {

        /*
         * As the build.xml specifies the arguments as argX, in case the
         * argument value is not given java takes the default value specified in
         * build.xml. To avoid that, below condition is used
         */
        try {
            // FIXME: update this if statement for this assignment
            if ((args.length != 6) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || args[3].equals("${arg3}") || args[4].equals("${arg4}") || args[5].equals("${arg5}")) {

                System.err.println("Error: Incorrect number of arguments. Program accepts 6 argumnets.");
                System.exit(0);
            }

            // System.out.println("Hello World! Lets get started with the assignment");
            debugger_val = Integer.valueOf(args[5]);
            if (debugger_val < 0 || debugger_val > 4) {
                System.out.println("Invalid debugValue :Must be between 0 and 4,including");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.err.println("Arguments not entered in proper format");
            e.printStackTrace();
            System.exit(1);
        }


        MyLogger.setDebugValue(debugger_val);


        TreeBuilder tree_og = new TreeBuilder(debugger_val);
        TreeBuilder tree_backup_1 = new TreeBuilder(debugger_val);
        TreeBuilder tree_backup_2 = new TreeBuilder(debugger_val);
        Node.Operations myvar = Node.Operations.INSERT;

        FileProcessor fp = new FileProcessor(debugger_val);
        String s = "";
        while (s != null) {
            s = fp.readLine(args[0]);
            if (s == null) {
                break;
            }
            readAns = s.split(":");
            // System.out.println(readAns[0]);
            int bnumber = Integer.valueOf(readAns[0]);
            //System.out.println(readAns[1]);
            String course = readAns[1];
            char[] letter = course.toCharArray();
            //Input validation
            if (letter.length > 1) {
                System.out.println("Wrong Course input in file  "+args[0]+"  for Bnumber : "+bnumber);
                System.exit(0);
            }
            if (bnumber < 1000 || bnumber > 9999) {
                System.out.println("Bnumber invalid : " + bnumber);
                continue;
            } else if (letter[0] < 65 || letter[0] > 75) {
                System.out.println("Course invalid : ");
                continue;
            }
            //first search that key if key found then that node ref is returned And if not found null is returned
            Node k = tree_og.search(tree_og.root, bnumber);
            //System.out.println(k);
            if (k != null) {
                //System.out.println("search found for Bnumber: "+bnumber);


                if (k.hm.get(course) != null) {
                    //System.out.println("Already there course");
                    continue;
                } else {
                    if (debugger_val == 3) {
                        System.out.println("course " + course + " added to Original tree for Bnumber " + bnumber);
                    }
                    k.hm.put(course, 1);
                    //   System.out.println("Here");

                    k.notifyAll(k.listners_list, course, myvar);

                }
            } else {
                Node Node_orig = new Node(bnumber, course, debugger_val);
                Node backup_Node_1 = new Node(bnumber, course, debugger_val);
                Node backup_Node_2 = new Node(bnumber, course, debugger_val);
                Node_orig.add(backup_Node_1);
                Node_orig.add(backup_Node_2);
                tree_og.insertNode(Node_orig);
                tree_backup_1.insertNode(backup_Node_1);
                tree_backup_2.insertNode(backup_Node_2);

            }
        }


        //System.out.println("Delete operations");
        fp = new FileProcessor(debugger_val);
        myvar = Node.Operations.DELETE;
        s = "";
        while (s != null) {
            s = fp.readLine(args[1]);
            if (s == null) {
                //System.out.println("null found");
                break;
            }
            readAns = s.split(":");
            int bnumber = Integer.valueOf(readAns[0]);
            String course = readAns[1];
            Node ans = tree_og.search(tree_og.root, bnumber);
            if (ans == null) {
                //System.out.println("Number not found");
                continue;
            } else {
                //System.out.println("Number found");
                if (ans.hm.remove(course) == null) {
                    if (debugger_val == 1) {
                        System.out.println("Course " + course + " is not available for deletion in Bnumber : " + bnumber);
                    }
                    continue;
                } else {
                    if (debugger_val == 2) {
                        System.out.println("Course " + course + " deleted from Original tree for Bnumber " + bnumber);
                    }
                    ans.hm.remove(course);
                    ans.notifyAll(ans.listners_list, course, myvar);
                }
            }
        }


        Results r_og = new Results(args[2], debugger_val);
        tree_og.printNodes(r_og, tree_og.root, debugger_val);
        Results r_backup_1 = new Results(args[3], debugger_val);
        tree_backup_1.printNodes(r_backup_1, tree_backup_1.root, debugger_val);
        Results r_backup_2 = new Results(args[4], debugger_val);
        tree_backup_2.printNodes(r_backup_2, tree_backup_2.root, debugger_val);


    }

    /**
     * It is a toString method and prints debugValue
     * @return -It returns a String
     *
     */
    public String toString(){
        System.out.println("Debugging value: "+debugger_val);
        return "Driver is being executed";
        }

    }


































