package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15649 {

    private static int n;
    private static int m;
    private static int[] numbers;
    private static boolean[] visited;

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        numbers = new int[m];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            numbers[0] = i;
            search(0);
            numbers[0] = 0;
            visited[i] = false;
        }

        System.out.print(sb);
    }

    public static void search(int count) {
        if (count == m - 1) {
            for (int number : numbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            numbers[count + 1] = i;
            search(count + 1);
            numbers[count + 1] = 0;
            visited[i] = false;
        }
    }
}
