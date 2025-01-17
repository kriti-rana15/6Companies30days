class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long sum = (long)mass;
        for(int ast: asteroids){
            if(sum<ast) return false;
            sum+=ast;
        }
        return true;
    }
}