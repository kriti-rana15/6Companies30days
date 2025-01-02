class Solution {
    public String getHint(String secret, String guess) {
        char[] charSecret = secret.toCharArray();
        char[] charGuess = guess.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[charSecret.length]; 
        for (int i = 0; i < charSecret.length; i++) {
            map.put(charSecret[i], map.getOrDefault(charSecret[i], 0) + 1);
        }
        int x = 0; 
        int y = 0; 
        for (int i = 0; i < charSecret.length; i++) {
            if (charSecret[i] == charGuess[i]) {
                x++;
                map.put(charSecret[i], map.get(charSecret[i]) - 1);
                visited[i] = true;
            }
        }
        for (int i = 0; i < charSecret.length; i++) {
            if (!visited[i] && map.getOrDefault(charGuess[i], 0) > 0) {
                y++; 
                map.put(charGuess[i], map.get(charGuess[i]) - 1); 
            }
        }
        return ""+x+"A"+y+"B";
    }
}