class Solution {
    static void linkdelete(Node head, int n, int m) {
        // your code here
        Node curr = head;
        Node last = curr;
        int i=0;
        while(curr!=null){
            if(i!=0 && (i%m)==0){
                int del=0;
                while(last!=null && curr!=null && del<n){
                    curr = curr.next;
                    last.next = curr;
                    del++;
                }
            }
            last = curr;
            if(curr!=null){
                curr=curr.next;
            }
            i++;
        }
        head = last;
    }
}