package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q1939 {

    private static int n;
    private static List<List<int[]>> bridges;
    private static boolean[] visited;
    private static int start;
    private static int end;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        bridges = new ArrayList<>();
        visited = new boolean[n + 1];
        max = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            bridges.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] island = br.readLine().split(" ");
            int a = Integer.parseInt(island[0]);
            int b = Integer.parseInt(island[1]);
            int limit = Integer.parseInt(island[2]);
            bridges.get(a).add(new int[]{b, limit});
            bridges.get(b).add(new int[]{a, limit});
        }

        String[] path = br.readLine().split(" ");
        start = Integer.parseInt(path[0]);
        end = Integer.parseInt(path[1]);

        search(new int[]{start, Integer.MAX_VALUE});

        System.out.println(max);
    }

    public static void bfs(int[] start) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(start);
        visited[start[0]] = true;


        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();

            for (int[] next : bridges.get(cur[0])) {
                if (visited[next[0]]) {
                    continue;
                }

                visited[next[0]] = true;
                int min = Math.min(cur[1], next[0]);
                if (next[0] == end) {
                    max = min;
                }
                dq.offerLast(new int[]{next[0], min});
            }
        }
    }

    public static void search(int[] cur) {
        if (cur[1] < max) {
            return;
        }

        if (cur[0] == end) {
            max = cur[1];
            return;
        }

        for (int[] next : bridges.get(cur[0])) {
            if (visited[next[0]]) {
                continue;
            }

            visited[next[0]] = true;
            search(new int[]{next[0], Math.min(cur[1], next[1])});
            visited[next[0]] = false;
        }
    }
}
