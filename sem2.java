import java.io.IOException;
import java.util.ArrayList;

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
    static ArrayList<Integer> signIndexesGlobal;

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> signIndexes = new ArrayList<>();
        String text = "?? + ?3 = ??";

        char[] textChar = text.replace(" ", "").toCharArray();
        // строки менять нельзя, поэтому конвертируем в char[] (одновременно убирая
        // пробелы)

        for (int i = 0; i < textChar.length; i++) {
            if (textChar[i] == '+' || textChar[i] == '=') {
                textChar[i] = '-';
            }
            // меняем символы на один символ для возможности разделения чисел
            if (textChar[i] == '?') {
                signIndexes.add(i);
            }
            // подсчитываем кол-во пропущенных чисел для определения размера массива
            // подставляемых чисел
        }

        textGlobal = textChar;
        signIndexesGlobal = signIndexes;

        // "Global" позволяет использовать переменную вне функции

        combWithRep(new int[signIndexes.size()], 0, 10);

    }

    public static void combWithRep(int[] comb, int index, int K) {
        if (index == comb.length) {
            // на место вопросов подставить comb, т.е. в textGlobal подставить значения из
            // numbers?

            // substituteValue(textGlobal, comb);
            checkComb(comb);
            return;
        }

        for (int i = 0; i < K; i++) {
            comb[index] = i;
            combWithRep(comb, index + 1, K);
        }
    }

    public static void checkComb(int[] comb) {
        for (int i = 0; i < comb.length; i++) {
            textGlobal[signIndexesGlobal.get(i)] = Character.forDigit(comb[i], 10);
        }

        String[] numbers = String.valueOf(textGlobal).split("-");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        int c = Integer.parseInt(numbers[2]);

        if (a + b == c) {
            System.out.printf("%d + %d = %d", a, b, c);
            System.out.println();
        }

    }

}
