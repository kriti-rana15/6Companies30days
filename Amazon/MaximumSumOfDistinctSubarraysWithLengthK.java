class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        long curr_sum = 0;
        long ans = 0;
        int n = nums.length;
        while(j < n){
            int element = nums[j];
            int exist_index = (map.containsKey(element) ? map.get(element) : -1);
            while((j - i + 1) > k || i <= exist_index){
                curr_sum -= nums[i];
                i++;
            }
            map.put(element, j);
            curr_sum += nums[j];
            if((j - i + 1) == k){
                ans = Math.max(ans , curr_sum);
            }
            j++;
        }
        return ans;
    }
}