
public class lc_1981 {
    static int subtractProductAndSum(int n) {
        int mult = 1,
            sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            mult *= lastDigit;
            sum += lastDigit; 
            n /= 10;                
        }
        mult *= n;
        sum += n;
    return mult - sum;
    }
    public static void main(String[] args) {
        // System.out.println(subtractProductAndSum(239)); 
    }}

