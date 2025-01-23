class ThroneInheritance {
    public TreeMap<String, List<String>> map = new TreeMap<>();
    public ThroneInheritance(String kingName) {
        list = new ArrayList<>();
        list.add("king");
    }
    
    public void birth(String parentName, String childName) {
        map.putIfAbsent(parentName, new ArrayList<>());
        map.get(parentName).add(childName);
    }
    
    public void death(String name) {
        if(map.contains(name)){
            map.remove(name);
        }
    }
    
    public List<String> getInheritanceOrder() {
        List<String> list = new ArrayList<>();
        list.add("king");
        for(String s: map){
            if(map.contains(s)){
                list.addAll()
            }
        }
    }
    public String Successor(String parentName, List<String> currOrder){

    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */