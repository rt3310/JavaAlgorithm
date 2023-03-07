package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11660 {

    private static int n;
    private static int m;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int total = 0;
            for (int j = 1; j <= n; j++) {
                total += Integer.parseInt(st.nextToken());
                if (i == 0) {
                    map[i][j] = total;
                    continue;
                }
                map[i][j] = total + map[i - 1][j];
            }
        }

        for (int i = 0; i < m; i++) {
            int total = 0;
            String[] xy = br.readLine().split(" ");
            int row1 = Integer.parseInt(xy[0]);
            int col1 = Integer.parseInt(xy[1]);
            int row2 = Integer.parseInt(xy[2]);
            int col2 = Integer.parseInt(xy[3]);

            total += map[row2][col2];
            total -= map[row1 - 1][col2];
            total -= map[row2][col1 - 1];
            total += map[row1 - 1][col1 - 1];

            sb.append(total).append("\n");
        }
        System.out.print(sb);
    }
}