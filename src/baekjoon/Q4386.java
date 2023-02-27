package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q4386 {
    private static List<double[]> stars;
    private static int[] parent;
    private static boolean check;

    static class Edge {
        private int v1;
        private int v2;
        private double distance;

        public Edge(int v1, int v2, double distance) {
            this.v1 = v1;
            this.v2 = v2;
            this.distance = distance;
        }

        public int getV1() {
            return v1;
        }

        public int getV2() {
            return v2;
        }

        public double getDistance() {
            return distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        stars = new ArrayList<>();
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            String[] xy = br.readLine().split(" ");
            double x = Double.parseDouble(xy[0]);
            double y = Double.parseDouble(xy[1]);
            stars.add(new double[]{x, y});
            parent[i] = i;
        }

        Queue<Edge> distances = new PriorityQueue<>(Comparator.comparingDouble(Edge::getDistance));
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                distances.offer(new Edge(i, j, Math.sqrt(Math.pow(Math.abs(stars.get(j)[0] - stars.get(i)[0]), 2) + Math.pow(Math.abs(stars.get(j)[1] - stars.get(i)[1]), 2))));
            }
        }

        double total = 0;
        int count = 0;
        while (count < n - 1) {
            Edge edge = distances.poll();
            union(edge.getV1(), edge.getV2());

            if (check) {
                count++;
                total += edge.getDistance();
            }
        }

        System.out.printf("%.2f", total);
    }

    public static int getParent(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = getParent(parent[x]);
    }

    public static void union(int a, int b) {
        check = false;
        a = getParent(a);
        b = getParent(b);

        if (a == b) {
            return;
        }
        parent[a] = b;
        check = true;
    }
}
