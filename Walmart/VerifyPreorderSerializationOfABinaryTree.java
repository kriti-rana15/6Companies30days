class Solution {
    public boolean isValidSerialization(String preorder) {
        int count =1;
        String[] arr = preorder.split(",");
        for (int i = 0; i < arr.length; i++) {
            count--; 
            if (count < 0) return false;
            if (!arr[i].equals("#")) count += 2;
        }
        return count == 0;
    }
}