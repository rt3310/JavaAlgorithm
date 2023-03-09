package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q7465 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");
            testCase();
        }

        System.out.println(sb);
    }

    public static void testCase() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            union(a, b);
        }

        int count = 0;
        boolean[] group = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            int root = getParent(i);
            if (!group[root]) {
                group[root] = true;
                count++;
            }
        }

        sb.append(count).append("\n");
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

        if (a == b) {
            return;
        }
        if (a < b) {
            parent[a] = b;
            return;
        }
        parent[b] = a;
    }
}
