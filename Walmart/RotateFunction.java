class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 0;
        }
        int ans = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            ans+=i*nums[i];
            sum+=nums[i];
        }
        int maxval = Integer.MIN_VALUE;
        maxval = Math.max(maxval, ans);
        ans = ans+sum;
        int j=n-1;
        for(int i = 1;i<nums.length;i++){
            ans = ans-(nums[j]*n);
            maxval = Math.max(maxval, ans);
            ans += sum;
            j--;
        }
        return maxval;
    }
}