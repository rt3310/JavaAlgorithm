package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10868 {

    private static int[] numbers;
    private static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        numbers = new int[n + 1];
        tree = new int[n * 4];

        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        init(1, n, 1);

        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            sb.append(getInterval(1, n, 1, a, b)).append("\n");
        }

        System.out.print(sb);
    }

    public static int init(int start, int end, int idx) {
        if (start >= end) {
            return tree[idx] = numbers[start];
        }

        int mid = (start + end) / 2;
        return tree[idx] = Math.min(init(start, mid, idx * 2), init(mid + 1, end, idx * 2 + 1));
    }

    public static int getInterval(int start, int end, int idx, int left, int right) {
        if (start > right || end < left) {
            return Integer.MAX_VALUE;
        }

        if (start >= left && end <= right) {
            return tree[idx];
        }

        int mid = (start + end) / 2;
        return Math.min(getInterval(start, mid, idx * 2, left, right), getInterval(mid + 1, end, idx * 2 + 1, left, right));
    }
}
