package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        long[] trees = new long[n];

        long max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            max = Long.max(max, trees[i]);
        }

        long left = 0;
        long right = max + 1;
        while (left < right) {
            long mid = (left + right) / 2;

            long bring = 0;
            for (long tree : trees) {
                bring += Long.max(tree - mid, 0);
            }

            if (bring >= m) {
                left = mid + 1;
                continue;
            }
            right = mid;
        }

        System.out.println(right - 1);
    }
}
