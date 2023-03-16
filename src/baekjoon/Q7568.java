package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] dungchis = new int[n][2];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            String[] dungchi = br.readLine().split(" ");
            dungchis[i] = new int[]{Integer.parseInt(dungchi[0]), Integer.parseInt(dungchi[1])};
        }

        for (int i = 0; i < n; i++) {
            result[i] = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (dungchis[j][0] > dungchis[i][0] && dungchis[j][1] > dungchis[i][1]) {
                    result[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
