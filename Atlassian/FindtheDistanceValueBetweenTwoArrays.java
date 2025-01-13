class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for(int i=0;i<arr1.length;i++){
            boolean check = false;;
            for(int j=0;j<arr2.length;j++){
                int val = Math.abs(arr1[i]-arr2[j]);
                if(val<=d){
                    check = true;
                    break;
                }
            }
            if(!check) count++;
        }
        return count;
    }
}