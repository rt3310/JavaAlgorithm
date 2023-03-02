package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2887 {

    static class Edge {
        private int vertex;
        private long distance;

        public Edge(int vertex, long distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public int getVertex() {
            return vertex;
        }

        public long getDistance() {
            return distance;
        }
    }

    private static int[] parent;
    private static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        List<long[]> planets = new ArrayList<>();
        planets.add(new long[0]);

        for (int i = 0; i < n; i++) {
            String[] xyz = br.readLine().split(" ");
            planets.add(new long[]{Long.parseLong(xyz[0]), Long.parseLong(xyz[1]), Long.parseLong(xyz[2])});
        }


        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                long[] vertex1 = planets.get(i);
                long[] vertex2 = planets.get(j);
                long min1 = Long.min(Math.abs(vertex1[0] - vertex2[0]), Math.abs(vertex1[1] - vertex2[1]));
                long minDistance = Long.min(min1, Math.abs(vertex1[2] - vertex2[2]));
                graph.get(i).add(new Edge(j, minDistance));
                graph.get(j).add(new Edge(i, minDistance));
            }
        }

        System.out.println(search(1, n - 1));
    }

    public static long search(int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(Edge::getDistance));
        pq.offer(new Edge(start, 0));

        long total = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int vertex = edge.getVertex();
            long distance = edge.getDistance();

            if (visited[vertex]) {
                continue;
            }

            visited[vertex] = true;
            total += distance;

            for (Edge e : graph.get(vertex)) {
                if (!visited[e.getVertex()]) {
                    pq.add(e);
                }
            }
        }

        return total;
    }
}
