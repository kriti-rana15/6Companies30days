class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xnew = Math.max(x1,Math.min(x2,xCenter));
        int ynew = Math.max(y1,Math.min(y2,yCenter));

        xnew = xCenter - xnew;
        ynew = yCenter - ynew;
        if(xnew * xnew + ynew*ynew <= radius*radius){
            return true;
        }
        return false;
    }
}