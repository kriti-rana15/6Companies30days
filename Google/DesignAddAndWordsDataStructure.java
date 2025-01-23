class WordDictionary {
    private Map<Integer, List<String>> map;

    public WordDictionary() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        int length = word.length();
        map.computeIfAbsent(length, k -> new ArrayList<>()).add(word);
    }
    private boolean solve(String word, String candidate) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != '.' && word.charAt(i) != candidate.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public boolean search(String word) {
        int length = word.length();
        if (!map.containsKey(length)) {
            return false;
        }
        for (String candidate : map.get(length)) {
            if (solve(word, candidate)) {
                return true; 
            }
        }
        return false; 
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */