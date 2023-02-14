package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10971 {

    private static int n;
    private static int[][] map;
    private static int goMin = Integer.MAX_VALUE;
    private static int comeMin = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited[0] = 1;
        trip(2,  visited, true);
        visited[0] = 0;
        System.out.println(goMin);
    }

    public static void trip(int count, int[] visited, boolean isGo) {
        if (count == n+1) {
            calc(visited, isGo);
            System.out.println(Arrays.toString(visited));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && i != count-1) {
                visited[i] = count;
                trip(count+1, visited, isGo);
                visited[i] = 0;
            }
        }
    }

    public static void calc(int[] visited, boolean isGo) {
        int[] path = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            path[visited[i]-1] = i;
        }
        System.out.println("path: " + Arrays.toString(path));

        for (int i = 1; i < n; i++) {
            total += map[i - 1][path[i]];
        }

        if (isGo) {
            goMin = Math.min(goMin, total);
            return;
        }
        comeMin = Math.min(comeMin, total);
    }
}
