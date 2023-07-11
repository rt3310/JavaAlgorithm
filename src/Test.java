import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    private static int[][] map;
    private static int[][] shortest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        shortest = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i == j) {
                    shortest[i][j] = 0;
                    continue;
                }
                shortest[i][j] = Integer.MAX_VALUE;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }

                    int min = Math.min(map[j][k], map[j][i] + map[i][k]);
                    shortest[j][k] = Math.min(shortest[j][k], min);
                }
            }
        }

        System.out.println(count);
        for (int[] row : shortest) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
