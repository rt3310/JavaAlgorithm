package structure.tree.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Kruskal {

    static class Edge {
        private final int vertex1;
        private final int vertex2;
        private final int weight;

        public Edge(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        public int getVertex1() {
            return vertex1;
        }

        public int getVertex2() {
            return vertex2;
        }

        public int getWeight() {
            return weight;
        }
    }

    private static List<Edge> edges;
    private static int[] parent;
    private static int res;
    private static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        edges = new ArrayList<>();
        parent = new int[10001];
        String[] ve = br.readLine().split(" ");
        int v = Integer.parseInt(ve[0]); // 정점의 개수
        int e = Integer.parseInt(ve[1]); // 간선의 개수

        // 자기 자신을 루트로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            String[] input = br.readLine().split(" ");
            int vertex1 = Integer.parseInt(input[0]);
            int vertex2 = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            edges.add(new Edge(vertex1, vertex2, weight));
        }

        // 가중치를 기준으로 오름차순 정렬
        edges.sort(Comparator.comparingInt(Edge::getWeight));


        for (int i = 0; i < e; i++) {
            // 정점1과 정점2를 union -> 다른 언어의 경우 예약어 주의
            union(edges.get(i).getVertex1(), edges.get(i).getVertex2());

            if (check) {
                res += edges.get(i).getWeight();
            }
        }

        System.out.println(res);
    }

    public static int getParent(int x) {
        // 자기 자신이면 루트 노드이므로 return
        if (x == parent[x]) {
            return x;
        }

        // 부모 노드를 재귀로 호출하며 탐색
        return parent[x] = getParent(parent[x]);
    }

    public static void union(int a, int b) {
        check = false;
        a = getParent(a);
        b = getParent(b);

        // 이미 같은 그래프에 속했으면 return -> 사이클이 있다는 의미
        if (a == b) {
            return;
        }
        // 같은 그래프가 아니라면 a를 부모 노드로 설정
        parent[a] = b;
        check = true;
    }
}
