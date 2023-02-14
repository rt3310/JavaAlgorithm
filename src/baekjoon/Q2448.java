package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2448 {

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n * 2 - 1];

        star(0, 0, n);

        for (int[] row : map) {
            for (int dot : row) {
                if (dot == 0) {
                    System.out.print(" ");
                    continue;
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void star(int r, int c, int depth) {
        if (depth == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    if (j < 3 - i - 1 || j >= 3 + i) {
                        continue;
                    }

                    if (i == 1 && j == 2) {
                        continue;
                    }
                    map[r + i][c + j] = 1;
                }
            }
        } else {
            star(r, c + depth / 2, depth / 2);
            star(r + depth / 2, c, depth / 2);
            star(r + depth / 2, c + depth, depth / 2);
        }
    }
}
