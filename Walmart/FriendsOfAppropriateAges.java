import java.util.Arrays;

class Solution {
    public int numFriendRequests(int[] ages) {
        int count = 0;
        int n = ages.length;
        Arrays.sort(ages);
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (ages[j] <= 0.5 * ages[i] + 7) break; 
                if (ages[j] > ages[i]) continue; 
                if (ages[j]>100 && ages[i]<100) continue;
                count++;
                if (ages[i] == ages[j]) count++;
            }
        }
        return count;
    }
}