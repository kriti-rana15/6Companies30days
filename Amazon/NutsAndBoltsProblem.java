class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Character> revMap = new HashMap<>();
        // code here
        char order[] = {'!','#','$','%','&','*','?','@','^'};
        for(int i=0;i<order.length;i++){
            map.put(order[i],i);
            revMap.put(i,order[i]);
        }
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = map.get(nuts[i]);
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            nuts[i] = revMap.get(arr[i]);
            bolts[i] = nuts[i];
        }
    }
}