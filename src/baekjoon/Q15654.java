package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15654 {

    private static int n;
    private static int r;
    private static int[] numbers;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        numbers = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            search(1, new StringBuilder(numbers[i] + " "));
            visited[i] = false;
        }
    }

    public static void search(int count, StringBuilder sb) {
        if (count == r) {
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                search(count + 1, new StringBuilder(sb.toString() + numbers[i] + " "));
                visited[i] = false;
            }
        }
    }
}
