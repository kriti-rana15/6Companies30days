class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int max_h = 1;
        int count = 1;
        for (int i = 0; i < hBars.length - 1; i++) {
            if (hBars[i] == hBars[i + 1] - 1) {
                count++;
            } else {
                count = 1;
            }
            max_h = Math.max(max_h, count);
        }
        count = 1;
        int max_v = 1;
        for (int i = 0; i < vBars.length - 1; i++) {
            if (vBars[i] == vBars[i + 1] - 1) {
                count++;
            } else {
                count = 1;
            }
            max_v = Math.max(max_v, count);
        }
        int mini = Math.min(max_h, max_v);
        return (mini + 1) * (mini + 1);
    }
}