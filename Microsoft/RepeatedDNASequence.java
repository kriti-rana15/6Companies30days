class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> v = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0 ; i+10<=s.length();i++){
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for(String it : map.keySet()){
            if(map.get(it) > 1)
                v.add(it);
        }
        return v;
    }
}