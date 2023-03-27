package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q13549 {

    private static int dest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        dest = Integer.parseInt(nk[1]);

        System.out.println(search(n));
    }

    public static int search(int start) {
        boolean[] visited = new boolean[100001];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{start, 0});
        visited[start] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int curPos = cur[0];
            int curTime = cur[1];

            if (curPos == dest) {
                return curTime;
            }

            if (curPos * 2 <= 100000 && !visited[curPos * 2]) {
                if (curPos * 2 == dest) {
                    return curTime;
                }
                visited[curPos * 2] = true;
                dq.offerLast(new int[]{curPos * 2, curTime});
            }

            if (curPos - 1 >= 0 && !visited[curPos - 1]) {
                if (curPos - 1 == dest) {
                    return curTime + 1;
                }
                visited[curPos - 1] = true;
                dq.offerLast(new int[]{curPos - 1, curTime + 1});
            }

            if (curPos + 1 <= 100000 && !visited[curPos + 1]) {
                if (curPos + 1 == dest) {
                    return curTime + 1;
                }
                visited[curPos + 1] = true;
                dq.offerLast(new int[]{curPos + 1, curTime + 1});
            }
        }

        return -1;
    }
}
