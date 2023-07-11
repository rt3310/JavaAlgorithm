package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q21943 {

    private static int n;
    private static int[] numbers;
    private static int[] switchedNumbers;
    private static boolean[] numberVisited;
    private static int[] multiples;
    private static boolean[] visited;
    private static int q;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        numbers = new int[n];
        switchedNumbers = new int[n];
        numberVisited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        String[] pq = br.readLine().split(" ");
        int p = Integer.parseInt(pq[0]);
        q = Integer.parseInt(pq[1]);

        multiples = new int[q];
        visited = new boolean[n];

        max = Integer.MIN_VALUE;

        numberSwitch(0);
        System.out.println(max);
    }

    public static void numberSwitch(int order) {
        if (order == n) {
            combination(0, 0);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (numberVisited[i]) {
                continue;
            }

            numberVisited[i] = true;
            switchedNumbers[order] = numbers[i];
            numberSwitch(order + 1);
            numberVisited[i] = false;
        }
    }

    public static void combination(int start, int r) {
        if (r == q) {
            max = Math.max(max, calc());
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            multiples[r] = i;
            combination(i + 1, r + 1);
            visited[i] = false;
        }
    }

    public static int calc() {
        List<Integer> tempNumbers = new ArrayList<>();

        int multipleIndex = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (multipleIndex < q && i == multiples[multipleIndex]) {
                tempNumbers.add(total);
                total = switchedNumbers[i];
                multipleIndex++;
                continue;
            }
            total += switchedNumbers[i];
        }
        tempNumbers.add(total);

        int result = 1;
        for (int tempNumber : tempNumbers) {
            result *= tempNumber;
        }

        return result;
    }
}
