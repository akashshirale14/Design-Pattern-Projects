package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
public class TreeBuilder{
    public Node root;
    private String finalString="";

   public TreeBuilder(int debugger){
       if(debugger==4){
           System.out.println("In TreeBuilder Constructor");
       }
    }

    /**
     *
     *Searches for a node in a tree recursively using root node in BST
     * https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
     * @param root-It is the current node which will be inserted
     * @param key-It is the Bnumber
     * @return -This method returns null or address of that node if found
     *
     */
    public Node search(Node root,int key){
        if(root==null || root.B_number==key){
            return root;
        }
        if(key<root.B_number){
            return search(root.left,key);
        }

        return search(root.right,key);
    }

    /**
     *
     *It calls the recusrive method for inserting node
     * @param current-It is the current node which will be inserted
     * @return -This method returns void
     *
     */
    public void insertNode(Node current){
        int key=current.B_number;
        root=insertNodeRec(root,key,current);
    }

    /**
     * This method helps to insert node in the right position in BST
     * https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
     * @param root -It takes the node whose courses we want to print
     * @param key-It is the Bnumber
     * @param current-It is the current node which will be inserted
     * @return -This method returns root node
     *
     */
    public Node insertNodeRec(Node root,int key,Node current){

        if(root==null){
            return current;
        }else{
            if(key<root.B_number){
                root.left=insertNodeRec(root.left,key,current );
            }
            else{
                root.right=insertNodeRec(root.right,key,current);
            }
        }
        return root;
    }

    /**
     * This method helps to print the Bnumber along with its respective courses
     * @param r-It is an instance of Results class
     * @param root -It takes the node whose courses we want to print
     * @param debugger-It takes the debugging value as input
     * @return -This method returns void
     *
     */
    public void printNodes(Results r,Node root,int debugger){

        printInorder(root);
        if(debugger==0) {
            r.writeToFile(finalString);
        }

    }
    /**
     * This method helps to print the Bnumber along with its respective courses in ascending order
     * It works like inordertraversal
     * @param node -It takes the root node and goes through all nodes
     * @return -This method returns void
     *
     */
    void printInorder(Node node)
    {
        if (node == null)
            return;

        printInorder(node.left);

        callPrintOutput(node.B_number,node);

        printInorder(node.right);
    }

    /**
     * This method helps to print the Bnumber along with its respective courses
     * @param Bnumber-It takes the current Bnumber as input
     * @param a -It takes the node whose courses we want to print
     * @return -This method returns void
     *
     */
    void callPrintOutput(int Bnumber,Node a){
        String ans=String.valueOf(Bnumber)+" : ";
        if(a.hm.isEmpty()){
            //System.out.println(ans);
            finalString=finalString+ans+"\n";
        }else {

            for (String i : a.hm.keySet()) {
                ans = ans + i + " ";
            }
            //System.out.println(ans);
            finalString=finalString+ans+"\n";
        }

    }
    /**
     * It is a toString method and prints root node and final output to stdout
     * @return -It returns a String
     *
     */
    public String toString() {
        System.out.println("This is root node : "+root);
        System.out.println("Final output: ");
        System.out.println(finalString);
        return "In Tree Builder class";
    }

}