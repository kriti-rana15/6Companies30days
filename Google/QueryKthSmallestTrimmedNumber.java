class Pair{
    String str;
    int idx;
    public Pair(String str, int idx){
        this.str = str;
        this.idx = idx;
    }
}
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int smallest = queries[i][0];
            int trim = queries[i][1];
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.str.equals(b.str) ? b.idx - a.idx : b.str.compareTo(a.str));
            for (int j = 0; j < nums.length; j++){
                String str = nums[j].substring(nums[j].length() - trim);

                pq.add(new Pair(str, j));
                if (pq.size() > smallest) {
                    pq.poll();
                }
            }
            ans[i] = pq.poll().idx;
        }
        return ans;
    }
}