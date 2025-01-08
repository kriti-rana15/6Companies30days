/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "null,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> q = new LinkedList<>();
        for(String n: nodes){
            q.add(n);
        }
        return recursive(q);
    }
    public TreeNode recursive(Queue<String>q){
        String curr = q.remove();
        if(curr.equals("null")){
            return null;
        }
        int val = Integer.parseInt(curr);
        TreeNode root = new TreeNode(val);
        root.left = recursive(q);
        root.right = recursive(q);
        return root;
    }
}