package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1509 {

    private static String s;
    private static int[][] dp;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        n = s.length();
        dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }

        for (int i = n - 1; i >= 0; i--) {
            checkOdd(i);
            if (i < n - 1) {
                checkEven(i);
            }
        }

        int idx = 0;
        int left = 0;
        while (idx < n) {
            idx += dp[idx][0];
            left++;
        }

        idx = n-1;
        int right = 0;
        while (idx >= 0) {
            idx -= dp[idx][1];
            right++;
        }

        for (char c: s.toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println();
        Arrays.stream(dp).forEach(a -> System.out.print(a[0] + " "));
        System.out.println();
        Arrays.stream(dp).forEach(a -> System.out.print(a[1] + " "));
        System.out.println();
        System.out.println(Math.min(left, right));
    }

    public static void checkOdd(int index) {
        int left = index;
        int right = index;
        int count = 1;
        while (left >= 0 && right < n) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            if (dp[left][0] > count || dp[right][1] > count) {
                count += 2;
                left--;
                right++;
                continue;
            }
            dp[left][0] = count;
            dp[right][1] = count;
            count += 2;
            left--;
            right++;
        }
    }

    public static void checkEven(int index) {
        int left = index;
        int right = index + 1;
        int count = 2;
        while (left >= 0 && right < n) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            if (dp[left][0] > count || dp[right][1] > count) {
                count += 2;
                left--;
                right++;
                continue;
            }
            dp[left][0] = count;
            dp[right][1] = count;
            count += 2;
            left--;
            right++;
        }
    }
}
