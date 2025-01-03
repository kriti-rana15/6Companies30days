class Solution {
    public int maxProduct =0;
    public boolean isPalindrome(StringBuilder s){
        String rev = "";
        for(int i=s.length()-1; i>=0; i--){
            rev+=s.charAt(i);
        }
        for(int i = 0;i<s.length(); i++){
            if(s.charAt(i) != rev.charAt(i))
                return false;
        }
        return true;
    }
    public void backtrack(String s, StringBuilder a, StringBuilder b, int index){
        // base case
        if (index >= s.length()) {
            if (isPalindrome(a) && isPalindrome(b)) {
                maxProduct = Math.max(maxProduct, a.length() * b.length());
            }
            return;
        }
        a.append(s.charAt(index));
        backtrack(s, a, b, index + 1);
        a.deleteCharAt(a.length() - 1);

        b.append(s.charAt(index));
        backtrack(s, a, b, index + 1);
        b.deleteCharAt(b.length() - 1);

        backtrack(s, a, b, index + 1);
    }
    public int maxProduct(String s) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        backtrack(s, a, b, 0);
        return maxProduct;
    }
}