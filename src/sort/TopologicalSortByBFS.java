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
        search();
    }

    public static void setInDegree() {
        for (int i = 1; i < graph.length; i++) {
            for (int next : graph[i]) {
                inDegree[next]++;
            }
        }
    }

    public static void search() {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i < graph.length; i++) {
            if (inDegree[i] == 0) {
                dq.offerLast(i);
            }
        }

        for (int i = 1; i < graph.length; i++) {
            if (dq.isEmpty()) {
                return;
            }

            int cur = dq.poll();
            System.out.print(cur + " ");

            for (int next : graph[cur]) {
                if (--inDegree[next] == 0) {
                    dq.offer(next);
                }
            }
        }
    }
}