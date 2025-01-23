class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0, i = -1;
        HashMap<Integer, Integer> freq = new HashMap();
        for (int j = 0; j < nums.length; j++) {
            freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            while (freq.get(nums[j]) > k) {
                i++;
                freq.put(nums[i], freq.get(nums[i]) - 1);
            }
            ans = Math.max(ans, j - i);
        }
        
        return ans;
    }
}