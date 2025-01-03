class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int left = 0;
        int n = nums.length;
        for(int i = 1;i<n;i++){
            if(nums[i-1] >= nums[i]) break;
            left++;
        }
        int right = n-1;
        for(int i = n-1 ; i>0 ; i--){
            if(nums[i-1] >= nums[i]) break;
            right--;
        }
        if(right == 0)
            return (n*(n+1))/2;

        int ans =  n - right + 1;
        for(int i =0;i<=left ;i++){
            while(right < n && nums[right] <= nums[i]){
                right++;
            }
            ans += n- right + 1;
        }
        return ans;
    }
}