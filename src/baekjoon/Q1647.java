package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q1647 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[2]));
        for (int i = 0; i < m; i++) {
            String[] abc = br.readLine().split(" ");
            int a = Integer.parseInt(abc[0]);
            int b = Integer.parseInt(abc[1]);
            int c = Integer.parseInt(abc[2]);
            pq.offer(new int[]{a, b, c});
        }

        Queue<Integer> answer = new PriorityQueue<>((v1, v2) -> Integer.compare(v2, v1));
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (union(cur[0], cur[1])) {
                answer.offer(cur[2]);
            }
        }

        long total = 0;
        answer.poll();
        while (!answer.isEmpty()) {
            total += answer.poll();
        }
        System.out.println(total);
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
            return false;
        }
        if (a < b) {
            parent[b] = a;
            return true;
        }
        parent[a] = b;
        return true;
    }
}
