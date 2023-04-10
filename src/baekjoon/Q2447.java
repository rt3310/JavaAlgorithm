package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2447 {

    private static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        square(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int[] row : map) {
            for (int dot : row) {
                if (dot == 0) {
                    sb.append(" ");
                    continue;
                }
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void square(int r, int c, int depth) {
        if (depth == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    map[r+i][c+j] = 1;
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    square(r + (depth / 3) * i, c + (depth / 3) * j, depth / 3);
                }
            }
        }
    }
}
