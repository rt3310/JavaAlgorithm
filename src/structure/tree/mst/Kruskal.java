package structure.tree.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {
    private static int v, e;
    private static int[][] graph;
    private static int[] parent;
    private static int finalCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ve = br.readLine().split(" ");
        v = Integer.parseInt(ve[0]);
        e = Integer.parseInt(ve[1]);
        graph = new int[e][3];
        parent = new int[v];
        finalCost = 0;

        for (int i = 0; i < e; i++) {
            String[] node = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                graph[i][j] = Integer.parseInt(node[j]);
            }
        }

        Arrays.sort(graph, Comparator.comparingInt(n -> n[2]));

        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }
    }
}
