class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<String> startSet = new HashSet<>();
        for (String word : startWords) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            startSet.add(new String(chars));
        }
        int count = 0;
        for (String word : targetWords) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            for (int i = 0; i < sortedWord.length(); i++) {
                StringBuilder sb = new StringBuilder(sortedWord);
                sb.deleteCharAt(i);
                if (startSet.contains(sb.toString())) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}