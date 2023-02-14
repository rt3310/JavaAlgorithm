package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1697 {

    private static int n;
    private static int k;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);

        int[] visited = new int[100001];

        search(new int[]{n, 0},  visited);
        System.out.println(answer);
    }

    public static void search(int[] start, int[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]] = start[1];

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == k) {
                answer = Math.min(answer, cur[1]);
            }

            if (cur[0] - 1 >= 0 && (visited[cur[0] - 1] > cur[1] + 1 || visited[cur[0] - 1] == 0)) {
                visited[cur[0] - 1] = cur[1] + 1;
                q.offer(new int[]{cur[0] - 1, cur[1] + 1});
            }

            if (cur[0] + 1 <= 100000 && (visited[cur[0] + 1] > cur[1] + 1 || visited[cur[0] + 1] == 0)) {
                visited[cur[0] + 1] = cur[1] + 1;
                q.offer(new int[]{cur[0] + 1, cur[1] + 1});
            }

            if (cur[0] * 2 <= 100000 && (visited[cur[0] * 2] > cur[1] + 1 || visited[cur[0] * 2] == 0)) {
                visited[cur[0] * 2] = cur[1] + 1;
                q.offer(new int[]{cur[0] * 2, cur[1] + 1});
            }
        }
    }
}
