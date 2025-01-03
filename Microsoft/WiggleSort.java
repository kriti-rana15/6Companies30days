class Solution {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        for(int i=1;i<nums.length;i+=2){
            nums[i] = pq.peek();
            pq.poll();
        }
        for(int i=0;i<nums.length;i+=2){
            nums[i] = pq.peek();
            pq.poll();
        }
    }
}