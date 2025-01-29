class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return ans;
        
        HashMap<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        backtrack(digits, 0, new StringBuilder(), ans, map);
        return ans;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> ans, HashMap<Integer, List<Character>> map) {
        if (index == digits.length()) {
            ans.add(current.toString());
            return;
        }
        int digit = Character.getNumericValue(digits.charAt(index));

        if (!map.containsKey(digit)) return; 
        List<Character> letters = map.get(digit);
        for (char letter : letters) {
            current.append(letter);
            backtrack(digits, index + 1, current, ans, map); 
            current.deleteCharAt(current.length() - 1);
        }
    }
}