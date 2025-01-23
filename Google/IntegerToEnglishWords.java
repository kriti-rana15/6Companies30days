class Solution {
    public String []ones = {"", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    public String []tens = {"Ten", "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    public String []hundereds = {"", "Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        return inwords(num);
    }
    public String inwords(int num){
        if (num < 10) {
            return ones[num];
        }
        if (num < 20) {
            return tens[num - 10];
        }
        if (num < 100) {
            return hundereds[num / 10] + (num % 10 != 0 ? " " + inwords(num % 10) : "");
        }
        if (num < 1000) {
            return inwords(num / 100) + " Hundred" + (num % 100 != 0 ? " " + inwords(num % 100) : "");
        }
        if (num < 1000000) {
            return inwords(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + inwords(num % 1000) : "");
        }
        if (num < 1000000000) {
            return inwords(num / 1000000) + " Million" + (num % 1000000 != 0 ? " " + inwords(num % 1000000) : "");
        }
        else return inwords(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + inwords(num % 1000000000) : "");
    }
}