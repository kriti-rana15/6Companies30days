class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length/2;
        int res = 0;
        if(nums.length % 2 == 0){
            res = (nums[mid-1] + nums[mid])/2;
        }
        else{
            res = nums[mid];
        }
        int sum=0;
        for(int i =0;i<nums.length;i++){
            sum += Math.abs(res - nums[i]);
        }

        return sum;
    }
}