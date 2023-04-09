package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1865 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static List<int[]> edges;
    private static long[] weights;
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
        edges = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        weights = new long[n + 1];
        Arrays.fill(weights, 100000001);
        weights[1] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            edges.add(new int[]{s, e, t});
            edges.add(new int[]{e, s, t});
        }

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            edges.add(new int[]{s, e, -t});
        }

        for (int i = 1; i <= n; i++) {
            for (int[] edge : edges) {
                int start = edge[0];
                int end = edge[1];
                int weight = edge[2];

                if (weights[end] > weights[start] + weight) {
                    weights[end] = weights[start] + weight;
                    if (i == n) {
                        sb.append("YES").append("\n");
                        return;
                    }
                }
            }
        }

        if (weights[1] < 0) {
            sb.append("YES").append("\n");
            return;
        }
        sb.append("NO").append("\n");

    }
}