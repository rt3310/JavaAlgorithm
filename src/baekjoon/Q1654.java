package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int[] lines = new int[k];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, lines[i]);
        }

        long maxLen = 0;
        int left = 0;
        int right = min;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int line : lines) {
                count += line / mid;
            }

            if (count < n) {
                right = mid;
                continue;
            }

            if (mid < maxLen) {
                left = mid + 1;
                continue;
            }
            maxLen = Math.max(maxLen, mid);
            right = mid;
        }

        System.out.println(maxLen);
    }
}
