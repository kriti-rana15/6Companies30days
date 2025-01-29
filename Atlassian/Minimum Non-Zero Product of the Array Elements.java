class Solution {
    private static final long MOD = 1_000_000_007;

    private long solve(long base, long exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base % MOD;

        if (exp % 2 == 0) {
            long temp = solve(base, exp / 2);
            return (temp * temp) % MOD;
        } else {
            long temp = solve(base, exp / 2);
            temp = (temp * temp) % MOD;
            return (temp * (base % MOD)) % MOD;
        }
    }

    public int minNonZeroProduct(int p) {
        long val = (1L << p) - 1;
        long exp = val / 2;     
        long base = val - 1;    

        long ans = solve(base, exp); 
        return (int) ((ans * (val % MOD)) % MOD); 
    }
}