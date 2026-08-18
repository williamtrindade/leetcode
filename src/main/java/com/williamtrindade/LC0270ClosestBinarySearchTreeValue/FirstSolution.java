package com.williamtrindade.LC0270ClosestBinarySearchTreeValue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FirstSolution {
    public double minDiff = 0.0;
    public int retVal = 0;
    public double target = 0.0;

    public int closestValue(TreeNode root, double target) {
        this.target = target;

        this.minDiff = this.getDiff(root.val, target);
        this.retVal = root.val;

        this.dfs(root);
        return this.retVal;
    }

    public double getDiff(double n1, double n2) {
        return Math.abs(n2 - n1);
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            this.dfs(node.left);
            this.dfs(node.right);
            if (this.getDiff(node.val, this.target) == this.minDiff) {
                this.retVal = Math.min(node.val, this.retVal);
            } else if (this.getDiff(node.val, this.target) < this.minDiff) {
                this.retVal = node.val;
                this.minDiff = this.getDiff(node.val, this.target);
            }
        }
    }
}