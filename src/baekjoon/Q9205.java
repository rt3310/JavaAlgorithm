package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q9205 {
    private static BufferedReader br;
    private static StringBuilder sb;
    private static int[][] path;
    private static boolean[] visited;
    private static int n;
    private static boolean canArrive;

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
        canArrive = false;
        n = Integer.parseInt(br.readLine());
        path = new int[n + 2][2];
        visited = new boolean[n + 2];
        String[] home = br.readLine().split(" ");
        path[0] = new int[]{Integer.parseInt(home[0]), Integer.parseInt(home[1])};
        for (int i = 1; i < n + 1; i++) {
            String[] mart = br.readLine().split(" ");
            path[i] = new int[]{Integer.parseInt(mart[0]), Integer.parseInt(mart[1])};
        }
        String[] dest = br.readLine().split(" ");
        path[n + 1] = new int[]{Integer.parseInt(dest[0]), Integer.parseInt(dest[1])};

        visited[0] = true;
        search(0);

        sb.append(canArrive ? "happy" : "sad").append("\n");
    }

    public static void search(int cur) {
        if (cur == n + 1) {
            canArrive = true;
            return;
        }

        if (canArrive) {
            return;
        }

        int[] curPos = path[cur];
        int curX = curPos[0];
        int curY = curPos[1];
        for (int i = 1; i < n + 2; i++) {
            if (visited[i]) {
                continue;
            }
            int[] next = path[i];
            if (Math.abs(next[0] - curX) + Math.abs(next[1] - curY) <= 1000) {
                visited[i] = true;
                search(i);
            }
        }
    }
}
