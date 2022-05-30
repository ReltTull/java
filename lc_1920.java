
public class lc_1920 {
    static int[] swappedMeaningForIndex(int[] nums) {
        int[] ans = new int [nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
        }
        static void printArray(int[] input) {
            for (int i = 0; i < input.length; i++) {
                System.out.println(input[i]);
            }
        }
        public static void main(String[] args) {
            printArray(swappedMeaningForIndex(new int[]{3, 0, 2, 1}));
        }       
}
