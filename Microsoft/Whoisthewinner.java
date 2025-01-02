class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        int i=0;
        while(q.size()!=1){
            if(i<k-1){
                q.add(q.remove());
                i++;
            }
            else{
                i=0;
                q.remove();
            }
        }
        return q.remove();
    }
}