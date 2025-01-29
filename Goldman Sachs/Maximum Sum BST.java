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
 *   
}*/
class Info{
    boolean isBST = true;
    int sum = 0;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    // public Info(boolean isBST, int sum, int max, int min){
    //     this.isBST = isBST;
    //     this.sum = sum;
    //     this.max = max;
    //     this.min = min;
    // }
}
class Solution {
    public int maxsum = 0;
    public Info LargestBST(TreeNode root){
        // if(root==null) return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        // Info leftInfo = LargestBST(root.left);
        // Info rightInfo = LargestBST(root.right);
        // int sum = root.val + leftInfo.sum + rightInfo.sum;
        // int min = Math.min(root.val, Math.max(rightInfo.max,leftInfo.min));
        // int max = Math.max(root.val, Math.min(leftInfo.max,rightInfo.min));
        // if(root.val<=leftInfo.max || root.val>=rightInfo.min) return new Info(false,sum,min,max);
        // if(leftInfo.isBST && rightInfo.isBST){
        //     maxsum = Math.max(maxsum, sum);
        //     return new Info(true, sum, min,max);
        // }
        // return new Info(false, sum, min,max); 
        if (root == null) {
            return new Info();
        }
        Info left = LargestBST(root.left);
        Info right = LargestBST(root.right);
        Info currNode = new Info();
        if (root.val > left.max && root.val < right.min && left.isBST && right.isBST) {
            currNode.isBST = true;
            currNode.sum = left.sum + right.sum + root.val;
            currNode.min = Math.min(root.val, left.min);
            currNode.max = Math.max(root.val, right.max);
            maxsum = Math.max(maxsum, currNode.sum);
        } else {
            currNode.isBST = false;
        }
        return currNode;
    }
    public int maxSumBST(TreeNode root) {
        //code here
        LargestBST(root);
        return maxsum;
    }
}