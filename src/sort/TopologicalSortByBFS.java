package sort;

import java.util.*;

public class TopologicalSortByBFS {

    private static int[][] graph = {{},
            {2, 4},
            {3, 5},
            {},
            {5},
            {6},
            {}};
    private static int[] inDegree;
    public static void main(String[] args) {
        inDegree = new int[graph.length];

        setInDegree();
        search(1);
    }

    public static void setInDegree() {
        for (int i = 1; i < graph.length; i++) {
            for (int next : graph[i]) {
                inDegree[next]++;
            }
        }
    }

    public static void search(int start) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);

        while (!dq.isEmpty()) {
            int cur = dq.poll();
            System.out.print(cur + " ");

            for (int next : graph[cur]) {
                if (inDegree[next] == 0) {
                    continue;
                }

                if (--inDegree[next] == 0) {
                    dq.offer(next);
                }
            }
        }
    }
}
