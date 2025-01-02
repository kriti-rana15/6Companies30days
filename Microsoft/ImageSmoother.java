class Solution {
    public int cnt = 9;
    public int element(int[][]img, int i,int j){
        if(i<0 || j<0){
            cnt--;
            return 0;
        }
        if(i>=img.length || j>=img[0].length){
            cnt--;
            return 0;
        }
        return img[i][j];
    }
    public int[][] imageSmoother(int[][] img) {
        int [][] dp = new int[img.length][img[0].length];
        for(int i=0;i<img.length;i++){
            for(int j=0;j<img[0].length;j++){

                dp[i][j] = (element(img,i,j)+ element(img,i-1,j-1)+ element(img,i-1,j)+ element(img,i,j-1)+element(img,i,j+1)+ element(img, i+1,j+1)+ element(img,i+1,j)+ element(img, i-1,j+1) + element(img, i+1,j-1))/cnt;
                cnt = 9;
            }
        }
        return dp;
    }
}