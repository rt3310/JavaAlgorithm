package structure.tree.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prim {

    static class Edge {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int getVertex() {
            return vertex;
        }

        public int getWeight() {
            return weight;
        }
    }

    private static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ve = br.readLine().split(" ");
        int v = Integer.parseInt(ve[0]); // 정점의 개수
        int e = Integer.parseInt(ve[1]); // 간선의 개수
        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            String[] input = br.readLine().split(" ");
            int vertex1 = Integer.parseInt(input[0]);
            int vertex2 = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            graph.get(vertex1).add(new Edge(vertex2, weight));
            graph.get(vertex2).add(new Edge(vertex1, weight));
        }

        System.out.println(search(1, v));
    }

    public static int search(int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        pq.offer(new Edge(start, 0));

        int total = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int vertex = edge.getVertex();
            int weight = edge.getWeight();

            if (visited[vertex]) {
                continue;
            }

            visited[vertex] = true;
            total += weight;

            for (Edge e : graph.get(vertex)) {
                if (!visited[e.vertex]) {
                    pq.add(e);
                }
            }
        }
        return total;
    }
}
