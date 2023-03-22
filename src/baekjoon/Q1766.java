package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1766 {

    private static int n;
    private static List<List<Integer>> graph;
    private static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new ArrayList<>();

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        inDegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph.get(a).add(b);
            inDegree[b]++;
        }

        search();
    }

    public static void search() {
        Queue<Integer> dq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                dq.offer(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dq.isEmpty()) {
                return;
            }

            int cur = dq.poll();
            System.out.print(cur + " ");
            for (int next : graph.get(cur)) {
                if (--inDegree[next] == 0) {
                    dq.offer(next);
                }
            }

        }
    }
}
