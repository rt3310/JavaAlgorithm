package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2042 {

    private static long[] numbers;
    private static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmk = br.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);

        numbers = new long[n];
        tree = new long[n * 4];

        for (int i = 0; i < n; i++) {
            numbers[i] = Long.parseLong(br.readLine());
        }
        init(0, n - 1, 1);

        List<Long> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            String[] abc = br.readLine().split(" ");
            int b = Integer.parseInt(abc[1]);
            if (abc[0].equals("1")) {
                long c = Long.parseLong(abc[2]);
                update(0, n - 1, 1, b - 1, c);
                numbers[b - 1] = c;
                continue;
            }
            int c = Integer.parseInt(abc[2]);
            sb.append(sum(0, n - 1, 1, b - 1, c - 1)).append("\n");
        }
        System.out.print(sb);
    }

    public static long init(int start, int end, int nodeIndex) {
        if (start == end) {
            return tree[nodeIndex] = numbers[start];
        }

        int mid = (start + end) / 2;

        return tree[nodeIndex] = init(start, mid, nodeIndex * 2) + init(mid + 1, end, nodeIndex * 2 + 1);
    }

    public static long sum(int start, int end, int nodeIndex, int left, int right) {
        if (start > right || end < left) {
            return 0;
        }

        if (start >= left && end <= right) {
            return tree[nodeIndex];
        }

        int mid = (start + end) / 2;

        return sum(start, mid, nodeIndex * 2, left, right) + sum(mid + 1, end, nodeIndex * 2 + 1, left, right);
    }

    public static void update(int start, int end, int nodeIndex, int updateIndex, long src) {
        if (updateIndex < start || updateIndex > end) {
            return;
        }
        tree[nodeIndex] += src - numbers[updateIndex];

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, nodeIndex * 2, updateIndex, src);
        update(mid + 1, end, nodeIndex * 2 + 1, updateIndex, src);
    }
}
