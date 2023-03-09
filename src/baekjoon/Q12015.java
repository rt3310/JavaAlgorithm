package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q12015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int maxLength = 0;
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[1000001][2];
        dp[0][0] = 1;
        dp[0][1] = numbers[0];

        int dpCount = 1;
        for (int i = 1; i < n; i++) {
            int curNum = numbers[i];
            boolean inserted = false;
            System.out.println("curNum = " + curNum);
            for (int j = dpCount - 1; j >= 0; j--) {
                if (curNum > dp[j][1]) {
                    System.out.println("dp = " + dp[j][1]);
                    for (int k = 0; k < dpCount; k++) {
                        System.out.print(dp[k][0] + " ");
                        System.out.print(dp[k][1] + " ");
                    }
                    System.out.println();
                    System.out.println("j = " + j);
                    inserted = true;
                    dp[j + 1][0] = dp[j][0] + 1;
                    dp[j + 1][1] = curNum;
                    dpCount = j + 2;
                    break;
                }
            }
            if (!inserted) {
                dp[0][0] = 1;
                dp[0][1] = curNum;
            }
        }

        for (int i = 0; i < dpCount; i++) {
            System.out.print(dp[i][0] + " ");
            System.out.print(dp[i][1] + " ");
        }

//        System.out.println(maxLength);
    }
}
