class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> list = new ArrayList<>();
        List<Integer> Aidx = new ArrayList<>();
        List<Integer> Bidx = new ArrayList<>();
        int index = s.indexOf(a);
        while (index != -1) {
            Aidx.add(index);
            index = s.indexOf(a, index + 1); // next occurence tk search kro!!!
        }
        index = s.indexOf(b);
        while (index !=-1){
            Bidx.add(index);
            index = s.indexOf(b, index + 1);
        }
        if(Aidx.size()==0 || Bidx.size()==0){
            return list;
        }
        for(int i=0;i<Aidx.size();i++){
            for(int j=0;j<Bidx.size();j++){
                if(Math.abs(Aidx.get(i)-Bidx.get(j))<=k){
                    if(!list.contains(Aidx.get(i))) list.add(Aidx.get(i));
                    break;
                }
            }
        }
        return list;
    }
}