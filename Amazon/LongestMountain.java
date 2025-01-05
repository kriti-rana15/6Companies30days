class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n-1;i++){
            int count = 1;
            while(i<n-1 && arr[i+1]>arr[i]){
                i++;
                count++;
            }
            if(count>1) map.put(i,count);
        }
        int ans = 0;
        for(int i=n-1;i>0;i--){
            int count = 1;
            while(i>0 && arr[i-1]>arr[i]){
                i--;
                count++;
            }
            if(map.containsKey(i) && count>1){
                ans = Math.max(ans, map.get(i)+count-1);
            }
        }
        if(ans<3){
            return 0;
        }
        return ans;
    }
}