import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;
    public int getResult() {
      	//implement this
        return result;
    }

    public void visitNode(TreeNode node) {
      	//implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
          result = result + leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long result = 1;
    private final int M = 1000000007;

    public int getResult() {
      	//implement this
        return (int) result;
    }

    public void visitNode(TreeNode node) {
      	//implement this
        if(node.getColor() == Color.RED){
            result = (result * node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
          if(leaf.getColor() == Color.RED){
              result = (result * leaf.getValue()) % M;
          }
    }
}

class FancyVisitor extends TreeVis {
    private int nonLeafEvenDepthSum = 0;
    private int greenLeaveSum = 0;

    public int getResult() {
      	//implement this
        return Math.abs(nonLeafEvenDepthSum - greenLeaveSum);
    }

    public void visitNode(TreeNode node) {
    	//implement this
        if(node.getDepth() % 2 == 0){
            nonLeafEvenDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
    	//implement this
        if(leaf.getColor() == Color.GREEN){
            greenLeaveSum += leaf.getValue();
        }
    }
}

public class Solution {
    private static int[] values;
    private static Color[] colors;
    private static HashMap<Integer, HashSet<Integer>> map;
    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner scan = new Scanner(System.in);
        int amountNodes = scan.nextInt();
        values = new int[amountNodes];
        colors = new Color[amountNodes];
        map = new HashMap<>(amountNodes);
        for( int i = 0; i < amountNodes; i++ ){
            values[i] = scan.nextInt();
        }
        for(int i = 0; i < amountNodes; i++){
            colors[i] = scan.nextInt() == 0 ?
                Color.RED : Color.GREEN;
        }
        for( int i = 0; i < amountNodes - 1; i++){
            int u = scan.nextInt();
            int v = scan.nextInt();
            HashSet<Integer> uNeigbors = map.get(u);
            if (uNeigbors == null){
                uNeigbors = new HashSet();
                map.put(u, uNeigbors);
            }
            uNeigbors.add(v);
            HashSet<Integer> vNeighbors = map.get(v);
            if(vNeighbors == null){
                vNeighbors = new HashSet<>();
                map.put(v, vNeighbors);
            }
            vNeighbors.add(u);
        }
        scan.close();
        if(amountNodes == 1){
            return new TreeLeaf(values[0], colors[0], 0);
        }
        TreeNode root = new TreeNode(values[0], colors[0], 0);
        addChildren(root, 1);
        return root;
    }
    private static void addChildren(TreeNode parent, Integer parentNumber){
        for(Integer treeNumber : map.get(parentNumber)){
            map.get(treeNumber).remove(parentNumber);
            HashSet<Integer> grandChildren = map.get(treeNumber);
            boolean childHasChild = (grandChildren != null && !grandChildren.isEmpty());
            Tree tree;
            if(childHasChild){
                tree = new TreeNode(values[treeNumber - 1], colors[treeNumber - 1], parent.getDepth());
            } else {
                tree = new TreeLeaf(values[treeNumber - 1], colors[treeNumber - 1], parent.getDepth());
            }
            parent.addChild(tree);
            if(tree instanceof TreeNode){
                addChildren((TreeNode) tree, treeNumber);
            }
        }
    }


    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}