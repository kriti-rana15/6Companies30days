class Solution {
    public static String encode(String s) {
        // code here
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++){
            Integer count = 1;
            char ch = s.charAt(i);
            while(i<s.length()-1 && ch==s.charAt(i+1)){
                count++;
                i++;
            }
            ans.append(ch).append(count);
        }
        return ans.toString();
    }
}