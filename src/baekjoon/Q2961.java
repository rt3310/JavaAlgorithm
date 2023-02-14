package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2961 {

    private static int n;
    private static List<Integer> s;
    private static List<Integer> b;
    private static int min = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        s = new ArrayList<>();
        b = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] sb = br.readLine().split(" ");
            s.add(Integer.parseInt(sb[0]));
            b.add(Integer.parseInt(sb[1]));
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            combi(i, 0, visited);
        }

        System.out.println(min);
    }

    public static void combi(int count, int start, boolean[] visited) {
        if (count == n) {
            calMin(visited);
            System.out.println(Arrays.toString(visited));
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combi(count+1, i+1, visited);
            visited[i] = false;
        }
    }

    public static void calMin(boolean[] visited) {
        int sTotal = 1;
        int bTotal = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sTotal *= s.get(i);
                bTotal += b.get(i);
            }
        }

        min = Math.min(min, Math.abs(sTotal - bTotal));
    }
}
