class Solution {
    public List<List<Integer>> buildGraph(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        int maxNodeValue = findMaxValue(root);

        // Initialize adjacency list
        for (int i = 0; i <= maxNodeValue; i++) {
            ans.add(new ArrayList<>());
        }
        // Perform level-order traversal to build the adjacency list
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            int currVal = curr.val;
            if (curr.left != null) {
                ans.get(currVal).add(curr.left.val);
                ans.get(curr.left.val).add(currVal);
                q.add(curr.left);
            }
            if (curr.right != null) {
                ans.get(currVal).add(curr.right.val);
                ans.get(curr.right.val).add(currVal);
                q.add(curr.right);
            }
        }
        return ans;
    }

    private int findMaxValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(root.val, Math.max(findMaxValue(root.left), findMaxValue(root.right)));
    }

    public int amountOfTime(TreeNode root, int start) {
        List<List<Integer>> graph = buildGraph(root);

        int minutes = -1; // Start at -1 to account for the last BFS level
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];

        // Start BFS from the given start node
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                for (int neighbor : graph.get(curr)) {
                    if (!visited[neighbor]) {
                        q.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            minutes++;
        }
        return minutes;
    }
}