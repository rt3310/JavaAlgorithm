package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1562 {

    private static int n;
    private static long total;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        total = 0;

        visited = new boolean[10];
        for (int i = 1; i < 10; i++) {
            visited[i] = true;
            search(i, 1);
            visited[i] = false;
        }
        System.out.println(total);
    }

    public static void search(int cur, int depth) {
        if (depth == n) {
            for (int i = 0; i < 10; i++) {
                if (!visited[i]) {
                    return;
                }
            }
            total++;
            return;
        }

        if (cur - 1 >= 0) {
            visited[cur - 1] = true;
            search(cur - 1, depth + 1);
            visited[cur - 1] = false;
        }
        if (cur + 1 < 10) {
            visited[cur + 1] = true;
            search(cur + 1, depth + 1);
            visited[cur + 1] = false;
        }
    }
}
