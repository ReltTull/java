package gb;

public class permutationsWithRepetitions {
    static void permutaionsWithTheRepetitons(int lenght, int maxValue, int fixer) {
        if(fixer == lenght-1) return;
        int [] arr = new int[lenght];
        for(int i = 0; i < lenght; i++) {
            if (i == fixer) {
                arr[i] = 0;
                i++;
            }            
            for (int j = 0; j < maxValue; j++) {
                arr[i] = j;
                System.out.println(arr[i]);
            }            
            permutaionsWithTheRepetitons(lenght, maxValue, fixer + 1);
        }
    }
    public static void main(String[] args) {
        permutaionsWithTheRepetitons(3, 2, 0);
    }

    
}
