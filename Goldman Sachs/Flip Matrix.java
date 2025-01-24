class Solution {
    private int row, col;
    private Set<String> set;
    private Random random;

    public Solution(int m, int n) {
        row = m;
        col = n;
        set = new HashSet<>();
        random = new Random();
    }

    public int[] flip() {
        while (true) {
            int index = random.nextInt(row * col);
            int r = index / col;
            int c = index % col;
            String cell = r + "," + c;
            if (!set.contains(cell)) {
                set.add(cell); 
                return new int[]{r, c}; 
            }
        }
    }
    public void reset() {
        set.clear(); 
    }
}