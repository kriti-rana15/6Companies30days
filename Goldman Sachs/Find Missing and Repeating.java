class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int a = -1, b = -1;
        int[] freq = new int[arr.length + 1];
        for (int num : arr) {
            freq[num]++;
        }
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 2) {
                a = i; 
            }
            if (freq[i] == 0) {
                b = i; 
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        return result;
    }
}