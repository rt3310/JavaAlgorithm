package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NumberMake {

    private static BufferedReader br;
    private static int n;
    private static int[] operators;
    private static int[] numbers;
    private static int minTotal;
    private static int maxTotal;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            testCase(i);
        }
    }

    public static void testCase(int testCount) throws IOException {
        n = Integer.parseInt(br.readLine());
        operators = new int[4];
        numbers = new int[n];
        minTotal = Integer.MAX_VALUE;
        maxTotal = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        while (st.hasMoreTokens()) {
            operators[count++] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer stNumber = new StringTokenizer(br.readLine(), " ");
        count = 0;
        while (stNumber.hasMoreTokens()) {
            numbers[count++] = Integer.parseInt(stNumber.nextToken());
        }

        search(1, numbers[0]);
        System.out.println("#" + testCount + " " + (maxTotal - minTotal));
    }

    public static void search(int count, int total) {
        if (count == n) {
            minTotal = Math.min(minTotal, total);
            maxTotal = Math.max(maxTotal, total);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                if (i == 0) {
                    search(count + 1, total + numbers[count]);
                }
                if (i == 1) {
                    search(count + 1, total - numbers[count]);
                }
                if (i == 2) {
                    search(count + 1, total * numbers[count]);
                }
                if (i == 3) {
                    search(count + 1, total / numbers[count]);
                }
                operators[i]++;
            }
        }
    }
}
