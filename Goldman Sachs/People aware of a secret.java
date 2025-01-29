class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        TreeMap<Integer, Integer> map = new TreeMap<>((k1, k2) -> Integer.compare(k2, k1));
        map.put(0, 1);
        int MOD = 1_000_000_007;
        for (int i = 1; i < n; i++) {
            int active = 0;
            for (int key : map.keySet()) {
                if (key >= delay - 1 && key < forget - 1) {
                    active = (active + map.get(key)) % MOD;
                }
            }
            TreeMap<Integer, Integer> tempMap = new TreeMap<>(map.comparator());
            for (Integer mp : map.keySet()) {
                tempMap.put(mp + 1, map.get(mp));
            }
            map = tempMap;
            map.put(0, active);
            map.remove(forget);
        }
        int count = 0;
        for (int value : map.values()) {
            count = (count + value) % MOD;
        }

        return count;
    }
}
