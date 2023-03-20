package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        long[] lines = new long[n];

        long max = 0;
        for (int i = 0; i < n; i++) {
            lines[i] = Long.parseLong(br.readLine());
            max = Long.max(max, lines[i]);
        }

        long left = 0;
        long right = max;
        while (left < right) {
            long mid = (left + right) / 2;

            long count = 0;
            for (long line : lines) {
                count += line / mid;
            }

            if (count < k) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }

        System.out.println(right - 1);
    }
}
