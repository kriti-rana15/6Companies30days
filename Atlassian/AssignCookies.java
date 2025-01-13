class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<s.length;i++){
            map.put(s[i], map.getOrDefault(s[i],0)+1);
        }
        for(int j=0;j<g.length;j++){
            if(map.containsKey(g[j])){
                count++;
                map.put(g[j], map.getOrDefault(g[j],0)-1);
            }
            if(map.get(g[j])<=0){
                map.remove(g[j]);
            }
        }
        return count;
    }
}