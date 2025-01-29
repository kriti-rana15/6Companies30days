class Solution{
    static String printMinNumberForPattern(String S){
        Stack<Integer> stk = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int num = 1;
        for (char c : S.toCharArray()) {
            stk.push(num);
            num++;
            if (c == 'I') {
                while (!stk.isEmpty()) {
                    ans.append(stk.pop());
                }
            }
        }
        stk.push(num);
        while (!stk.isEmpty()) {
            ans.append(stk.pop());
        }
        return ans.toString();
    }
}