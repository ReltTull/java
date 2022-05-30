
public class lc_1981 {
    static int subtractProductAndSum(int n) {
        if (n<10) return 0;
        int mult = 1,
            sum = 0;
        while (n > 9) {
            int elem = n % 10;
            mult *= elem;
            sum += elem; 
            n /= 10;                
        }
        mult *= n;
        sum += n;
        int result = mult - sum;
    return result;
    }
    public static void main(String[] args) {
        // System.out.println(subtractProductAndSum(239)); 
    }}

