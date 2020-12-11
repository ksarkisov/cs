/*Katherine Sarkisov Period 6 12/11/20
*BST - provide a minary search tree that stores object in increasing order
*/
import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class Sarkisov_BST<E extends Comparable<E>> {
    
    private TreeNode root;

    public Sarkisov_BST(){

    }

    public void insert(E item){

        if(root == null)
            root = new TreeNode (item, null, null);
        else
            root = insert(item, root);
    }

    public TreeNode insert(E item, TreeNode node){

        int compared = node.data.compareTo(item);

        if(compared == 0){
            node.editOccurences(1);
            return node;
        }

        if(compared > 0){

            if(node.left == null)
                node.left = new TreeNode(item, null, null);
            else
                node.left = insert(item, node.left);
        }
        else{
            if(node.right == null)
                node.right = new TreeNode(item, null, null);
            else
                node.right = insert(item, node.right);
        }
        return node;
    }


    //print helper method - prints node.data that # of time that the data occurs
    private void printOccurences(TreeNode node){

        for(int i = 0; i < node.occurences; i ++)
            System.out.print(node.data + " ");
    }
    //prints root in order
    public void inOrder(){

        inOrder(root);
    }

    //recursive method to print in order
    private void inOrder(TreeNode node){

        if(node == null)
            return;
        
        inOrder(node.left);

        if(node.occurences > 1)
            printOccurences(node);
        else
            System.out.print(node.data + " ");

        inOrder(node.right);
    }

    //prints preorder
    public void preOrder(){

        preOrder(root);
    }

    //recursive method to print in preorder
    private void preOrder(TreeNode node){

        if(node == null)
            return;
        
        if(node.occurences > 1)
            printOccurences(node);
        else
            System.out.print(node.data + " ");

        preOrder(node.left);
        preOrder(node.right);
    }

    //print postorder
    public void postOrder(){

        postOrder(root);
    }

    //recursive method to print post order
    private void postOrder(TreeNode node){

        if(node == null)
            return;
        
        postOrder(node.left);
        postOrder(node.right);

        if(node.occurences > 1)
            printOccurences(node);
        else
            System.out.print(node.data + " ");
    }

    public static void main(String [] args){
        Sarkisov_BST<Integer> bst = new Sarkisov_BST<Integer>();
        bst.insert(3);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        bst.insert(2);
        bst.insert(5);
        bst.inOrder();


    }

    public class TreeNode{
		
		private E data;
		private TreeNode left;
        private TreeNode right;
        private int occurences;
		
		public TreeNode(E d, TreeNode l, TreeNode r){
			data = d;
			left = l;
            right = r;
            occurences = 1;
        }
        
        //method to allow client to edit the number of occurences of node
        public void editOccurences(int num){
            occurences += num;
        }

	}
}
