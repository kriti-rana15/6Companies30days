class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> possiblePairs = new ArrayList<>();
        if (n <= 45) helper(k, n, 1, possiblePairs, new ArrayList<>());
        return possiblePairs;
    }

    private void helper(int k, int n, int value, List<List<Integer>> possiblePairs, List<Integer> pairs) {
        int possiblePairsize = pairs.size();
        if (possiblePairsize == k && n == 0) {
            possiblePairs.add(new ArrayList<>(pairs));
            return;
        }
        for (int i = value; i < 10; i++) {
            if (possiblePairsize > k || n < 0) break;
            pairs.add(i);
            helper(k, n - i, i + 1, possiblePairs, pairs);
            pairs.remove(pairs.size() - 1);
        }
    }
}