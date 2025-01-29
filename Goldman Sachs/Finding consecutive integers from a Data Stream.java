class DataStream {
    private int v;
    private int c;
    private int count;

    public DataStream(int value, int k) {
        v = value;
        c = k;
        count = 0;
    }

    public boolean consec(int num) {
        if (num == v) {
            count++; 
        } else {
            count = 0;
        }
        return count >= c; 
    }
}