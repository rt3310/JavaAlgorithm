package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15650 {

    private static StringBuilder sb;
    private static int n;
    private static int r;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            search(i, i + 1, 1, new StringBuilder(i + " "));
            visited[i] = false;
        }
    }

    public static void search(int num, int start, int count, StringBuilder sb) {
        if (count == r) {
            System.out.println(sb);
            return;
        }

        for (int i = start; i <= n; i++) {
            visited[i] = true;
            search(i, i + 1, count + 1, new StringBuilder(sb.toString() + i + " "));
            visited[i] = false;
        }
    }
}
