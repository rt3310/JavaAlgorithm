package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q20543 {
    
    private static int n;
    private static int m;
    private static int[][] map;
    private static int[][] result;
    private static int[][] sum;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][n];
        result = new int[n][n];
        sum = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        for (int i = 0; i < n - (m - 1); i++) {
            for (int j = 0; j < n - (m - 1); j++) {
                result[i + (m / 2)][j + (m / 2)] = -map[i][j];
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < m; l++) {
                        map[i + k][j + l] += result[i + (m / 2)][j + (m / 2)];
                    }
                }
            }
        }

        for (int[] r : map) {
            for (int v : r) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
        System.out.println();


        for (int[] r : result) {
            for (int v : r) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
