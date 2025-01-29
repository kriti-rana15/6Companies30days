class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<List<Integer>> ans = new HashSet<>(); 
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> res = new ArrayList<>(); 
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                res.add(nums[j]);
                if (nums[j] % p == 0) {
                    count++;
                }
                if (count > k) {
                    break;
                }
                ans.add(new ArrayList<>(res));
            }
        }
        return ans.size();
    }
}