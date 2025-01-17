class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n: nums){
            pq.add(n);
        }
        int i=0;
        while(i<k){
            int num = pq.poll();
            num+=1;
            pq.add(num);
            i++;
        }
        int MOD = 1_000_000_007;
        long product = 1; 
        while (!pq.isEmpty()) {
            product = (product * pq.poll()) % MOD;  
        }
        return (int) product;
    }
}