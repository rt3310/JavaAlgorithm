package search;

public class PloydWarshall {

    private static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, INF, 6},
                {3, 0, 7, INF},
                {5, INF, 0, 4},
                {INF, INF, 2, 0}};

        int n = 4;

        for (int m = 0; m < n; m++) {
            for (int s = 0; s < n; s++) {
                for (int e = 0; e < n; e++) {
                    graph[s][e] = Math.min(graph[s][e], graph[s][m] + graph[m][e]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
