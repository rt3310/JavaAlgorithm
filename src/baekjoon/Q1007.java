package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1007 {

    private static int n;
    private static BufferedReader br;
    private static StringBuilder sb;
    private static int[][] pos;
    private static boolean[] visited;
    private static double min;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            testcase();
        }

        System.out.print(sb);
    }

    public static void testcase() throws IOException {
        n = Integer.parseInt(br.readLine());
        pos = new int[n][2];
        visited = new boolean[n];
        min = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            pos[i][0] = Integer.parseInt(input[0]);
            pos[i][1] = Integer.parseInt(input[1]);
        }

        visited[0] = true;
        search(0, pos[0], new int[]{0, 0});
        visited[0] = false;

        sb.append(min).append("\n");
    }

    public static void search(int depth, int[] cur, int[] total) {
        if (depth == n - 1) {
            min = Double.min(min, Math.sqrt(Math.pow(Math.abs(total[0]), 2) + Math.pow(Math.abs(total[1]), 2)));
            return;
        }

        if (depth % 2 == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                int[] subTotal = {pos[i][0] - cur[0], pos[i][1] - cur[1]};
                search(depth + 1, new int[]{0, 0}, new int[]{total[0] + subTotal[0], total[1] + subTotal[1]});
                visited[i] = false;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                search(depth + 1, new int[]{pos[i][0], pos[i][1]}, total);
                visited[i] = false;
            }
        }
    }
}
