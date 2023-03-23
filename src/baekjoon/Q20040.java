package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q20040 {

    private static int n;
    private static int[] parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        parent = new int[n + 1];
        n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int cycle = 0;
        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            if (union(a, b)) {
                cycle++;
            }
        }

        System.out.println(cycle);
    }

    public static int getParent(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = getParent(parent[x]);
    }

    public static boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a == b) {
            return true;
        }

        if (a < b) {
            parent[b] = a;
            return false;
        }
        parent[a] = b;
        return false;
    }
}
