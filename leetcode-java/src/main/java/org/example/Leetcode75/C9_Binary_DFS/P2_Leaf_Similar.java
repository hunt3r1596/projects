package org.example.Leetcode75.C9_Binary_DFS;

import java.util.ArrayList;
import java.util.List;

public class P2_Leaf_Similar {

    List<Integer> leaf1 = new ArrayList<>();
    List<Integer> leaf2 = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        P2_Leaf_Similar leaf_similar = new P2_Leaf_Similar();
        System.out.println(leaf_similar.leafSimilar(root1, root2));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        traverse(root1, leaf1);
        traverse(root2, leaf2);

        return leaf1.equals(leaf2);
    }

    public void traverse(TreeNode root, List<Integer> leaf) {
        if (root.left == null && root.right == null)
            leaf.add(root.val);
        else {
            if(root.left != null)
                traverse(root.left, leaf);

            if(root.right != null)
                traverse(root.right, leaf);
        }
    }
}
