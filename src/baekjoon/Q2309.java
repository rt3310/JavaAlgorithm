package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2309 {

    private static int[] mans;
    private static int[] answer;
    private static boolean isfinish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        mans = new int[9];
        answer = new int[7];
        isfinish = false;

        for (int i = 0; i < 9; i++) {
            mans[i] = Integer.parseInt(br.readLine());
        }

        boolean[] visited = new boolean[9];

        combi(0, 0, visited);

        for (int k : Arrays.stream(answer).sorted().toArray()) {
            System.out.println(k);
        }
    }

    public static void combi(int count, int start, boolean[] visited) {
        if (count == 7) {
            if (isfinish) {
                return;
            }
            isfinish = check(visited);
            return;
        }

        for (int i = start; i < 9; i++) {
            visited[i] = true;
            combi(count+1, i+1, visited);
            visited[i] = false;
        }
    }

    public static boolean check(boolean[] visited) {
        int total = 0;
        for (int i = 0; i < 9; i++) {
            if (visited[i]) {
                total += mans[i];
            }
        }

        if (total == 100) {
            int count = 0;
            for (int i = 0; i < 9; i++) {
                if (visited[i]) {
                    answer[count++] = mans[i];
                }
            }
            return true;
        }
        return false;
    }
}
