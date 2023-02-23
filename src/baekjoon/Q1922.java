package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q1922 {
    static class Edge {
        private int from;
        private int to;
        private int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getWeight() {
            return weight;
        }
    }
    private static int n;
    private static int m;
    private static List<Edge> edges;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        edges = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String[] abc = br.readLine().split(" ");
            edges.add(new Edge(Integer.parseInt(abc[0]), Integer.parseInt(abc[1]), Integer.parseInt(abc[2])));
        }

        edges.sort(Comparator.comparingInt(Edge::getWeight));

        int total = 0;
        for (int i = 0; i < m; i++) {
            Edge edge = edges.get(i);
            if (union(edge.getFrom(), edge.getTo())) {
                total += edge.getWeight();
            }
        }

        System.out.println(total);
    }

    public static int getParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = getParent(parent[x]);
    }

    public static boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a == b) {
            return false;
        }

        if (a < b) {
            parent[b] = a;
            return true;
        }
        parent[a] = b;
        return true;
    }
}
