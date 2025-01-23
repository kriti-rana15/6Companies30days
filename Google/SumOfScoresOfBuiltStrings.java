class Solution {
    private int[] computeLPS(String s) {
        int[] lps = new int[s.length()];
        int len = 0;
        
        for (int i = 1; i < s.length(); i++) {
            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = lps[len - 1];
            }
            if (s.charAt(i) == s.charAt(len)) len++;
            lps[i] = len;
        }
        return lps;
    }
    public long sumScores(String s) {
        long sum = 0;
        int[] lps = computeLPS(s);
        int[] countPrefixSuffix = new int[s.length()];
        
        for (int i = 0; i < lps.length; i++) {
            if (lps[i] == 0) {
                countPrefixSuffix[i] = 0;
            } else {
                countPrefixSuffix[i] = countPrefixSuffix[lps[i] - 1] + 1;
            }
        }
        
        for (int count : countPrefixSuffix) {
            sum += count;
        }
        sum += s.length();  // Include the full length of the string itself
        return sum;
    }
}