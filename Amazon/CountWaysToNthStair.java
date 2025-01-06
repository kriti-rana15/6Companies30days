class Solution {
    public Map<String, Integer> map;
    public int solve(int index ,int jump, boolean is_possible,int k){
        int ans = 0;
        // base case
        String key = (index+""+jump+""+is_possible);
        if(map.containsKey(key)) return map.get(key);
        if(index > k+1)return 0;

        if(index == k)ans++;

        if(is_possible)
            ans  += solve(index - 1,jump,false,k);

        ans += solve(index + (int)Math.pow(2,jump),jump+1,true,k);
        map.put(key,ans);
        return ans;
    }
    public int waysToReachStair(int k) {
        map = new HashMap<>();
        return solve(1,0,true,k);
    }
}