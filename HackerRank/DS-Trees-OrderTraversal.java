// https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
// Tree: Level Order Traversal
import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
	/* 
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
        if(root == null) 
            return;
        Queue<Node> nodesInLevel = new LinkedList<Node>();
        nodesInLevel.add(root);
        while(!nodesInLevel.isEmpty()){
            Node current = nodesInLevel.peek();
            System.out.print(current.data + " ");
            if(current.left != null)
                nodesInLevel.add(current.left);
            if(current.right != null)
                nodesInLevel.add(current.right);
            nodesInLevel.remove();
        }
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}