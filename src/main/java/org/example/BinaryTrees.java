package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Maximum depth: height of the root node
 * Minimum depth: shortest path from root to leaf node
 */
public class BinaryTrees {

    static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isSameTree(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return root1.value == root2.value
                && isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }

    public static boolean isSubTree(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return isSameTree(root1, root2)
               || isSubTree(root1.left, root2)
               || isSubTree(root1.right, root2);
    }

    public static boolean isBalancedAtRoot(BinaryTreeNode root){
        if (root == null) return true;
        return Math.abs(getNodeHeight(root.left) - getNodeHeight(root.right)) <= 1;
    }

    public static boolean isBalancedAtEveryNode(BinaryTreeNode root){
        if (root == null) return true;
        return Math.abs(getNodeHeight(root.left) - getNodeHeight(root.right)) <= 1
                && isBalancedAtEveryNode(root.left) && isBalancedAtEveryNode(root.right);
    }

    public static int getNodeHeight(BinaryTreeNode node){
        if (node == null) return 0;
        return Math.max(getNodeHeight(node.left), getNodeHeight(node.right)) + 1;
    }

    public static int getMinDepth(BinaryTreeNode root){
        if (root == null) return 0;
        int left = getMinDepth(root.left);
        int right = getMinDepth(root.right);
        return (left == 0 || right == 0)
                ? left + right + 1
                : Math.min(left, right) + 1;
    }

    public static List<Integer> getRightView(BinaryTreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode curr = queue.poll();
                if (curr != null) {
                    if (curr.left != null) queue.add(curr.left);
                    if (curr.right != null) queue.add(curr.right);
                    // Change to (i == 0) for left view
                    if (i == levelSize - 1) res.add(curr.value);
                }
            }
        }
        return res;
    }

}
