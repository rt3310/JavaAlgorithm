package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1043 {

    private static int[] parent;
    private static List<List<Integer>> parties;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        parent = new int[n + 1];
        parties = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        String[] mans = br.readLine().split(" ");
        int manCount = Integer.parseInt(mans[0]);
        if (manCount == 0) {
            System.out.println(m);
            return;
        }

        int root = Integer.parseInt(mans[1]);
        for (int i = 1; i < manCount; i++) {
            union(Integer.parseInt(mans[i]), Integer.parseInt(mans[i + 1]));
        }

        for (int i = 0; i < m; i++) {
            String[] participant = br.readLine().split(" ");
            int participantCount = Integer.parseInt(participant[0]);
            parties.add(new ArrayList<>());
            List<Integer> curParty = parties.get(i);

            for (int j = 1; j < participantCount; j++) {
                int cur = Integer.parseInt(participant[j]);
                int next = Integer.parseInt(participant[j + 1]);
                curParty.add(cur);
                union(cur, next);
            }
            curParty.add(Integer.parseInt(participant[participantCount]));
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            List<Integer> curParty = parties.get(i);
            boolean isCan = true;
            for (Integer member : curParty) {
                if (find(root, member)) {
                    isCan = false;
                    break;
                }
            }
            if (isCan) {
                count++;
            }
        }

        System.out.println(count);
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
