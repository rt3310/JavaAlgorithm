package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        dp[0] = 1;

        int maxLength = 0;
        long[] numbers = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            long curNum = numbers[i];
            int maxNum = 0;
            for (int j = i-1; j >= 0; j--) {
                if (curNum > numbers[j]) {
                    maxNum = Math.max(maxNum, dp[j]);
                    if (dp[j] == j + 1) {
                        break;
                    }
                }
            }
            dp[i] = maxNum + 1;
            maxLength = Math.max(maxLength, maxNum + 1);
        }

        int answer = 0;
        long[] results = new long[maxLength];
        for (int i = 0; i < maxLength; i++) {
            results[i] = 1000000001;
        }

        for (int i = 0; i < n; i++) {
            results[dp[i]-1] = Math.min(results[dp[i]-1], numbers[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (long result : results) {
            sb.append(result).append(" ");
        }

        System.out.println(maxLength);
        System.out.println(sb);
    }
}
