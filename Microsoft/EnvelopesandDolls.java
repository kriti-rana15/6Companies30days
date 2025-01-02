// Initially i did this question like this
class Solution {
    public int lis(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int arr2[] = new int[set.size()];
        int k=0;
        for(int s: set){
            arr2[k++] = s; 
        }
        Arrays.sort(arr2);
        int n = arr.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr[i-1]==arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int nums[] = new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            int arr[] = envelopes[i];
            nums[i] = arr[1];
        }
        return lis(nums);
    }
}

// But for 2 cases it is showing "MEMORY LIMIT EXCEEDED." so i upsolved this question.

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int ans = 0;
        for (int[] env : envelopes) {
            int height = env[1];
            int left = Arrays.binarySearch(dp, 0, ans, height);
            if (left < 0) left = -left - 1;
            if (left == ans) ans++;
            dp[left] = height;
        }
        return ans;
    }
}