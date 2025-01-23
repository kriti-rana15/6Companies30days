class LRUCache {
    public HashMap<Integer, Integer> map;
    public int cp = 0;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        cp = capacity;
    }
    
    public int get(int key) {
        int val = -1;
        if(map.containsKey(key)){
            val = map.get(key);
            map.remove(key);
            map.put(key, val);
        }
        return val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        } 
        else {
            if (map.size() == cp) {
                int lruKey = map.keySet().iterator().next();
                map.remove(lruKey);
            }
            map.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */