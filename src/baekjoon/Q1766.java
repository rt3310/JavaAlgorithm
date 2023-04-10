package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1766 {

    private static int n;
    private static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        parent = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            union(a, b);
        }

        System.out.println(Arrays.toString(parent));
    }

    public static int getParent(int x) {
        if (parent[x] == x) {
            return x;
        }

        return getParent(parent[x]);
    }

    public static void union(int a, int b) {
        if (a < b) {
            parent[b] = a;
            return;
        }
        parent[a] = b;
    }
}
