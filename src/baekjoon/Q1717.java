package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1717 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        parent = new int[n + 1];
        int m = Integer.parseInt(nm[1]);

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            if (input[0].equals("0")) {
                union(a, b);
                continue;
            }
            if (find(a, b)) {
                sb.append("YES").append("\n");
                continue;
            }
            sb.append("NO").append("\n");
        }

        System.out.print(sb);
    }

    public static int getParent(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = getParent(parent[x]);
    }

    public static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a < b) {
            parent[b] = a;
            return;
        }
        parent[a] = b;
    }

    public static boolean find(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        return a == b;
    }
}
