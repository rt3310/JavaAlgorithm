package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17471 {
    private static int n;
    private static List<Set<Integer>> graph;
    private static int[] populations;
    private static boolean[] visited1;
    private static boolean[] visited2;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        graph.add(new HashSet<>());
        populations = new int[n + 1];
        visited1 = new boolean[n + 1];
        visited2 = new boolean[n + 1];
        visited1[0] = true;
        visited2[0] = true;
        min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            graph.add(new HashSet<>());
            populations[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer graphSt = new StringTokenizer(br.readLine());
            int edgeCount = Integer.parseInt(graphSt.nextToken());
            for (int j = 0; j < edgeCount; j++) {
                int toVertex = Integer.parseInt(graphSt.nextToken());
                graph.get(i).add(toVertex);
                graph.get(toVertex).add(i);
            }
        }

        search(0, 1);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void search(int count, int start) {
        if (count == n) {
            if (isConnected()) {
                min = Math.min(min, getMinimumSub());
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!visited1[i]) {
                visited1[i] = true;
                search(count + 1, i + 1);
                visited1[i] = false;
            }
            if (!visited2[i]) {
                visited2[i] = true;
                search(count + 1, i + 1);
                visited2[i] = false;
            }
        }
    }

    private static int getMinimumSub() {
        int visited1Total = 0;
        int visited2Total = 0;
        for (int i = 1; i <= n; i++) {
            if (visited1[i]) {
                visited1Total += populations[i];
                continue;
            }
            visited2Total += populations[i];
        }

        return Math.abs(visited1Total - visited2Total);
    }

    public static boolean isConnected() {
        boolean[] v1 = new boolean[n + 1];
        boolean[] v2 = new boolean[n + 1];
        v1[0] = true;
        v2[0] = true;
        int start1 = getStart(visited1);
        int start2 = getStart(visited2);

        if (start1 == -1 || start2 == -1) {
            return false;
        }

        searchConnection(v1, visited1, start1);
        searchConnection(v2, visited2, start2);

        return checkConnection(v1, visited1) && checkConnection(v2, visited2);
    }

    public static int getStart(boolean[] visited) {
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                return i;
            }
        }
        return -1;
    }

    private static boolean checkConnection(boolean[] visited, boolean[] connectedGraph) {
        for (int i = 1; i <= n; i++) {
            if (visited[i] != connectedGraph[i]) {
                return false;
            }
        }
        return true;
    }

    public static void searchConnection(boolean[] visited, boolean[] connectedGraph, int cur) {
        Set<Integer> nexts = graph.get(cur);
        visited[cur] = true;
        for (int next : nexts) {
            if (connectedGraph[next] && !visited[next]) {
                visited[next] = true;
                searchConnection(visited, connectedGraph, next);
            }
        }
    }
}
