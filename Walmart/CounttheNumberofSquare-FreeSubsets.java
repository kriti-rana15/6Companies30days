// Question in Progress. 

class Solution {
    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(2); ans.add(3); ans.add(5); ans.add(7); ans.add(11); ans.add(13); ans.add(17); ans.add(19); ans.add(23);ans.add(29);
    public int squareFreeSubsets(int[] nums) {
        int notsquare = 0;
        int dp[] = new int[nums.length];
        ArrayList<Integer> primenum = new ArrayList<>();
        ArrayList<Integer> composite = new ArrayList<>();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(ans.contains(nums[i])){
                primenum.add(nums[i]);
            }
            else{
                composite.add(nums[i]);
            }
        }
        for(int i=0;i<premium.length;i++){
            for(int j=0;j<composite.length;i++){
                if(nums[j]%nums[i]==0){
                    
                }
            }
        }

    }
}