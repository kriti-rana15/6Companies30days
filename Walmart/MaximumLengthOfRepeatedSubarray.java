class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int maxn = 0;
        int n = nums1.length;
        int m = nums2.length;
        int dp[][] = new int[n+1][m+1]; 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    maxn = Math.max(maxn, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return maxn;
    }
}