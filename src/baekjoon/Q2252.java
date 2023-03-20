package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2252 {

    private static int n;
    private static int[] inDegree;
    private static List<List<Integer>> graph;
    private static List<Integer> order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        inDegree = new int[n + 1];
        graph = new ArrayList<>();
        order = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            graph.get(a).add(b);
            inDegree[b]++;
        }

        search();
        for (int v : order) {
            sb.append(v).append(" ");
        }

        System.out.println(sb);
    }

    public static void search() {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                dq.offerLast(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (dq.isEmpty()) {
                return;
            }

            int cur = dq.pollFirst();
            order.add(cur);

            for (int next : graph.get(cur)) {
                if (--inDegree[next] == 0) {
                    dq.offerLast(next);
                }
            }
        }
    }
}