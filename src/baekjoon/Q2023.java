package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2023 {

    private static int[] numbers;
    private static int[] p = {1, 3, 5, 7, 9};
    private static int[] q = {2, 3, 5, 7};
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 4; i++) {
            numbers = new int[n];
            numbers[0] = q[i];
            dupPerm(0);
        }
    }

    public static void dupPerm(int count) {
        int number = toInt(numbers, count + 1);
        if (!isPrime(number)) {
            return;
        }

        if (count == n - 1) {
            System.out.println(number);
            return;
        }

        for (int i = 0; i < p.length; i++) {
            numbers[count + 1] = p[i];
            dupPerm(count + 1);
        }
    }

    public static int toInt(int[] ns, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(ns[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        if (number != 2 && number % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= (int) Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
