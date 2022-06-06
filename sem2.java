import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

// Напишите метод, который сжимает строку. Пример: вход aaaabbbcdd, результат - a4b3cd2
public class sem2 {

    // Напишите метод, который принимает на вход строку (String) и определяет
    // является
    // ли строка палиндромом (возвращает boolean значение)
    // public static void main(String[] args) {
    // System.out.println(polind("abaa"));
    // }

    // public static boolean polind(String s) {
    // for (int i = 0;i < s.length()/2;++i){
    // if (s.charAt(i) != s.charAt((s.length()-1)-i)) {
    // return false;
    // }
    // }
    // return true;
    // }

    // static String CountOfDoubles(String input) {
    // String res = "";
    // int count = 1;
    // for(int i = 1; i < input.length(); i++) {
    // if (input.charAt(i) == input.charAt(i-1)) {
    // count += 1;
    // }
    // else {
    // res += input.charAt(i-1) + Integer.toString(count);
    // count = 1;
    // }
    // }
    // res += input.charAt(input.length()-1) + Integer.toString(count);
    // return res;
    // }
    // public static void main(String[] args) {
    // System.out.println(CountOfDoubles("aaabbbeeeuuuuyyy"));
    // }

    // Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть
    // заменены знаком
    // вопроса, например 2? + ?5 = 69. Требуется восстановить выражение до верного
    // равенства.
    // Предложить хотя бы одно решение или сообщить, что его нет.

    static char[] textGlobal;
    public static char[] substituteValue(char[] array, int[] substituted) {
        int subsIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == '?') {
                char subs = (char) substituted[subsIndex];
                array[i] = subs;
                subsIndex += 1;
            }
        }
        return array;
    }




    public static void main(String[] args) throws IOException {
        ArrayList<Integer> signIndexes = new ArrayList<>();
        // String text = "5? + 7? = 1??";
        String text = "?5 + 7? = 1??";

        char[] textChar = text.replace(" ", "").toCharArray();

        for (int i = 0; i < textChar.length; i++) {
            if (textChar[i] == '+' || textChar[i] == '=') {
                textChar[i] = '-';
            }
            if (textChar[i] == '?') {
                signIndexes.add(i);
            }
        }

        textGlobal = textChar;
        String[] numbers = String.valueOf(textChar).split("-");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        int c = Integer.parseInt(numbers[2]);

        if (a + b == c) {
            System.out.println(textChar);
        }
        System.out.println(Arrays.toString(numbers));

    }

    public static void combWithRep(int[] comb, int index, int K) {
        if (index == comb.length) {
            // на место вопросов подставить comb, т.е. в textGlobal подставить значения из
            // numbers?
            substituteValue(textGlobal, comb);
            return;
        }

        for (int i = 0; i < K; i++) {
            comb[index] = i;
            combWithRep(comb, index + 1, K);
        }
    }

}
