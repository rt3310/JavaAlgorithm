package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12738 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = numbers[0];
        int dpCount = 1;
        for (int i = 1; i < n; i++) {
            int left = 0;
            int right = dpCount;
            while (left < right) {
                int mid = (left + right) / 2;

                if (dp[mid] < numbers[i]) {
                    left = mid + 1;
                    continue;
                }
                right = mid;
            }
            dp[right] = numbers[i];
            if (right == dpCount) {
                dpCount++;
            }
        }

        System.out.println(dpCount);
    }
}