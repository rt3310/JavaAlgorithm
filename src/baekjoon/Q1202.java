package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[][] jewelries = new int[n][2];
        Integer[] bags = new Integer[k];
        Queue<Integer> q = new PriorityQueue<>();
        long total = 0;

        for (int i = 0; i < n; i++) {
            String[] mv = br.readLine().split(" ");
            int m = Integer.parseInt(mv[0]);
            int v = Integer.parseInt(mv[1]);
            jewelries[i] = new int[]{m, v};
        }

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelries, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return  o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        Arrays.sort(bags);

        int count = 0;
        for (int i = 0; i < k; i++) {
            while (count < n && jewelries[count][0] <= bags[i]) {
                q.offer(-jewelries[count][1]);
                count++;
            }

            if (!q.isEmpty()) {
                total += -q.poll();
            }
        }

        System.out.println(total);
    }
}
