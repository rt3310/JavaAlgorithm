package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] numbers = new int[n][2];
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = new int[]{Integer.parseInt(st.nextToken()), 0};
        }

        dp[0] = numbers[0][0];
        int dpCount = 1;
        for (int i = 1; i < n; i++) {
            int left = 0;
            int right = dpCount;
            while (left < right) {
                int mid = (left + right) / 2;

                if (dp[mid] < numbers[i][0]) {
                    left = mid + 1;
                    continue;
                }
                right = mid;
            }
            dp[right] = numbers[i][0];
            numbers[i][1] = right;
            if (right == dpCount) {
                dpCount++;
            }
        }

        System.out.println(dpCount);
        int[] answer = new int[dpCount];
        int idx = dpCount - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (numbers[i][1] == idx) {
                answer[idx] = numbers[i][0];
                idx--;
            }
        }

        for (int num : answer) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}