package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q18111 {

    private static int n;
    private static int m;
    private static int b;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmb = br.readLine().split(" ");
        n = Integer.parseInt(nmb[0]);
        m = Integer.parseInt(nmb[1]);
        b = Integer.parseInt(nmb[2]);
        map = new int[n][m];

        int maxHeight = 0;
        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int resultHeight = 0;
        for (int i = minHeight; i <= maxHeight; i++) {
            int remain = 0;
            int time = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    remain += i - map[j][k];
                    if (map[j][k] == i) {
                        continue;
                    }
                    if (map[j][k] > i) {
                        time += Math.abs(i - map[j][k]) * 2;
                        continue;
                    }
                    time += Math.abs(i - map[j][k]);
                }
            }

            if (b - remain < 0) {
                continue;
            }

            if (time <= minTime) {
                if (time == minTime && i > resultHeight) {
                    resultHeight = i;
                    continue;
                }
                minTime = time;
                resultHeight = i;
            }
        }

        System.out.println(minTime + " " + resultHeight);
    }
}
