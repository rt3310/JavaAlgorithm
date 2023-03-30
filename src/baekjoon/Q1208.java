package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1208 {

    private static int n;
    private static int s;
    private static int[] numbers;
    private static int[] tree;
    private static int count;
    private static int positiveTotal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ns = br.readLine().split(" ");
        n = Integer.parseInt(ns[0]);
        s = Integer.parseInt(ns[1]);
        count = 0;

        numbers = new int[n];
        tree = new int[n * 4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        positiveTotal = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            if (numbers[i] > 0) {
                positiveTotal += numbers[i];
            }
        }

        search(0, 0);

        System.out.println(count);
    }

    public static void search(int cur, int total) {
        if (total + positiveTotal < s) {
            return;
        }

        if (total >= s) {
            if (total == s) {
                count++;
            }
            return;
        }

        if (cur == n) {
            return;
        }

        search(cur + 1, total + numbers[cur]);
        search(cur + 1, total);
    }
}
