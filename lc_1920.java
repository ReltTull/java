
public class lc_1920 {
    static int[] swappedMeaningForIndex(int[] inputArray) {
        int[] result = new int [inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            result[i] = inputArray[inputArray[i]];
        }
        return result;
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
