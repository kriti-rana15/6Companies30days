class Solution {
    static final int MOD = 1_000_000_007; 
    Map<Integer, Integer> freq = new HashMap<>(); 
    private int pow(int a, int b, int m) {
        long ans = 1;
        long base = a; 
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * base) % m;
            }
            base = (base * base) % m; 
            b /= 2;
        }
        return (int) ans;
    }
    private int solve(int el, long pr, long lans) {
        if (el > 30) {
            return pr > 1 ? (int) lans : 0;
        }
        int ans = solve(el + 1, pr, lans);
        if (el % 4 != 0 && el % 9 != 0 && el % 25 != 0 && gcd(el, pr) == 1) {
            ans += solve(el + 1, pr * el, lans * freq.getOrDefault(el, 0) % MOD);
            ans %= MOD; 
        }
        return ans;
    }
    public int numberOfGoodSubsets(int[] nums) {
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = (int) ((solve(2, 1, 1) * (long) pow(2, freq.getOrDefault(1, 0), MOD)) % MOD);
        return ans;
    }
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}