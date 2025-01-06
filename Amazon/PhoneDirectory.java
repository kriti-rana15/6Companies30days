class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n,String contact[], String s){
        // code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        int k = 0;
        for(int i=1;i<=s.length();i++){
            ArrayList<String> innerAns = new ArrayList<>();
            String str = s.substring(k,i);
            for(int j=0;j<n;j++){
                int idx = contact[j].indexOf(str);
                if(idx>-1){
                    if (!innerAns.contains(contact[j])) { // Check if the element is not already in the list
                        innerAns.add(contact[j]);
                    }
                }
            }
            if(innerAns.size()==0){
                innerAns.add("0");
            }
            Collections.sort(innerAns);
            ans.add(innerAns);
        }
        return ans;
    }
}