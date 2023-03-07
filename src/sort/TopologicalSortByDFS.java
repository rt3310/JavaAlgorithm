package sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TopologicalSortByDFS {

    private static int[][] graph = {{},
            {2, 4},
            {3, 5},
            {},
            {5},
            {6},
            {}};
    private static Deque<Integer> vertexes;
    private static boolean[] visited;
    public static void main(String[] args) {
        vertexes = new ArrayDeque<>();
        visited = new boolean[graph.length];

        for (int i = 1; i < graph.length; i++) {
            if (visited[i]) {
                continue;
            }
            search(i);
        }

        System.out.println(vertexes);
    }

    public static void search(int cur) {
        for (int next : graph[cur]) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            search(next);
        }

        vertexes.addFirst(cur);
    }
}
