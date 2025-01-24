class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> accessTimes) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (List<String> access : accessTimes) {
            String employee = access.get(0);
            int timestamp = Integer.parseInt(access.get(1));
            map.putIfAbsent(employee, new ArrayList<>());
            map.get(employee).add(timestamp);
        }
        List<String> result = new ArrayList<>();
        
        for (String entry : map.keySet()) {
            List<Integer> times = map.get(entry);
            Collections.sort(times);
            for (int i = 0; i < times.size(); i++) {
                int j = i;
                while (j < times.size() && times.get(j) - times.get(i) < 100) {
                    j++;
                }
                if (j - i >= 3) {
                    result.add(entry);
                    break;
                }
            }
        }
        return result;
    }
}
