class Pair{
    String str;
    int freq;
    public Pair(String str, int freq){
        this.str = str;
        this.freq = freq;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        for(String w: words){
            map.put(w,map.getOrDefault(w,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.freq==b.freq ? a.str.compareTo(b.str) : b.freq - a.freq);
        for(String w: map.keySet()){
            pq.add(new Pair(w,map.get(w)));
        }
        while((k--)>0 && pq.size()>0){
            String st = pq.poll().str;
            list.add(st);
        }
        return list;
    }
}