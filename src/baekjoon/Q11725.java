package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q11725 {
    private static List<List<Integer>> tree;
    private static int[] parent;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        tree = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        visited[1] = true;
        search(1);

        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static void search(int cur) {
        for (int child : tree.get(cur)) {
            if (!visited[child]) {
                visited[child] = true;
                parent[child] = cur;
                search(child);
                visited[child] = false;
            }
        }
    }
}
