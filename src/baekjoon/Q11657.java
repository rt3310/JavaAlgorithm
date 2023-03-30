package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11657 {

    private static int n;
    private static int m;
    private static List<int[]> edges;
    private static int[] weights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        edges = new ArrayList<>();
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        weights = new int[n + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[1] = 0;

        for (int i = 0; i < m; i++) {
            String[] abc = br.readLine().split(" ");
            int a = Integer.parseInt(abc[0]);
            int b = Integer.parseInt(abc[1]);
            int c = Integer.parseInt(abc[2]);
            edges.add(new int[]{a, b, c});
        }

        for (int i = 1; i <= n; i++) {
            if (search(i)) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(Arrays.toString(weights));
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            if (weights[i] == Integer.MAX_VALUE) {
                sb.append(-1).append("\n");
                continue;
            }
            sb.append(weights[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static boolean search(int cur) {
        for (int[] edge : edges) {
            int startNode = edge[0];
            int nextNode = edge[1];
            int nextWeight = edge[2];

            if (weights[startNode] != Integer.MAX_VALUE && weights[nextNode] > weights[cur] + nextWeight) {
                weights[nextNode] = weights[startNode] + nextWeight;
                if (cur == n - 1) {
                    return true;
                }
            }

        }
        return false;
    }
}
