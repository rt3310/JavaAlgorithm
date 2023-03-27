package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1865 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static List<List<int[]>> map;
    private static int[][] wormHole;
    private static int n;

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
        map = new ArrayList<>();
        String[] nmw = br.readLine().split(" ");
        n = Integer.parseInt(nmw[0]);
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        wormHole = new int[n + 1][2];

        int m = Integer.parseInt(nmw[1]);
        for (int i = 0; i < m; i++) {
            String[] set = br.readLine().split(" ");
            int s = Integer.parseInt(set[0]);
            int e = Integer.parseInt(set[1]);
            int t = Integer.parseInt(set[2]);
            map.get(s).add(new int[]{e, t});
        }
        int w = Integer.parseInt(nmw[2]);
        for (int i = 0; i < w; i++) {
            String[] set = br.readLine().split(" ");
            int s = Integer.parseInt(set[0]);
            int e = Integer.parseInt(set[1]);
            int t = Integer.parseInt(set[2]);
            wormHole[s] = new int[]{e, t};
        }

        boolean possible = false;
        for (int i = 1; i <= n; i++) {
            if (search(i)) {
                possible = true;
            }
        }
        sb.append(possible ? "YES" : "NO").append("\n");
    }

    public static boolean search(int start) {
        boolean[] visited = new boolean[n + 1];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{start, 0});

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int curPos = cur[0];
            int curWeight = cur[1];

            if (curPos == start && curWeight < 0) {
                return true;
            }

            if (wormHole[curPos][0] != 0) {
                dq.offerLast(new int[]{wormHole[curPos][0], curWeight - wormHole[curPos][1]});
                continue;
            }

            for (int[] next : map.get(curPos)) {
                int nextPos = next[0];
                int nextWeight = next[1];
                if (visited[nextPos]) {
                    continue;
                }
                visited[nextPos] = true;
                dq.offerLast(new int[]{nextPos, curWeight + nextWeight});
            }
        }
        return false;
    }
}
