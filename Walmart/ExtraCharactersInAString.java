class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int minlength = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        String str = s;
        for(int i=0;i<dictionary.length;i++){
            if(s.indexOf(dictionary[i])>=0){
                set.add(dictionary[i]);
            }
        }
        for(int i=0;i<dictionary.length;i++){
            str = s;
            if(str.indexOf(dictionary[i])>=0) str = str.replace(dictionary[i],"");
            for(String st: dictionary){
                if(str.indexOf(st)>=0) str = str.replace(st,"");
            }
            minlength = Math.min(minlength, str.length());
        }
        return minlength;
    }
}