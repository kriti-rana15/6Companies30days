class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> (a[0]-b[0])); 

        // Add element with index to priority queue
        for(int i=0; i<nums.length; i++){
            q.offer(new int[]{nums[i],i});
            if(q.size()> k){
                q.poll();
            }
        }
        
        // Set to keep index
        Set<Integer> index = new HashSet<>();
        
        // Add the index in the set since index are unique 
        while(!q.isEmpty()){
            int[] top = q.poll();
            index.add(top[1]);
        }
        
        // Final result add here
        int[] result = new int[k];
        int p =0;
        for(int i=0; i< nums.length; i++){
            if(index.contains(i)){
                result[p] = nums[i];
                ++p;
            }
        }
        return result;
    }
}