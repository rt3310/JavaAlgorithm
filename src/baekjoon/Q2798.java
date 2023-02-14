package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2798 {

    private static int n;
    private static int m;
    private static int[] cards;
    private static int min = 100000;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        boolean[] visited = new boolean[n];

        cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        combi(0, 0, visited);

        System.out.println(answer);
    }

    public static void combi(int count, int start, boolean[] visited) {
        if (count == 3) {
            check(visited);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combi(count+1, i+1, visited);
            visited[i] = false;
        }
    }

    public static void check(boolean[] visited) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                total += cards[i];
            }
        }

        if (total <= m && m - total < min) {
            answer = total;
            min = m - total;
        }
    }
}
