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
class Solution {
    private int[] solve(TreeNode root, int distance) {
        if (root == null) {
            return new int[12];
        }

        if (root.left == null && root.right == null) {
            int[] dist = new int[12];
            dist[0] = 1; // Root is a leaf node, so count of leaf node at index 0 is 1
            return dist;
        }

        int[] dist = new int[12];
        int[] left = solve(root.left, distance);
        int[] right = solve(root.right, distance);

        // Combine results by shifting the distance to the right by 1
        for (int i = 0; i < 10; i++) {
            dist[i + 1] = left[i] + right[i];
        }

        dist[11] += left[11] + right[11];

        // Check all good pairs
        for (int d1 = 0; d1 <= distance; d1++) {
            for (int d2 = 0; d2 <= distance; d2++) {
                if (d1 + d2 + 2 <= distance) {
                    dist[11] += left[d1] * right[d2];
                }
            }
        }

        return dist;
    }

    public int countPairs(TreeNode root, int distance) {
        return solve(root, distance)[11];
    }
}