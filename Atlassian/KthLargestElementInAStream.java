class KthLargest {
    ArrayList<Integer> st;
    int k=0;
    public KthLargest(int k, int[] nums) {
        st = new ArrayList<>(nums.length);
        this.k = k;
        for(int val: nums){
            st.add(val);
        }
        Collections.sort(st);
    }
    
    public int add(int val) {
        st.add(val);
        Collections.sort(st);
        return st.get(st.size()-k);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */