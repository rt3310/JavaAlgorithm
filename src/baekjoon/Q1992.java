package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1992 {

    private static int n;
    private static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new String[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }

        System.out.println(search(0, 0, n));
    }

    public static String search(int r, int c, int size) {
        if (size == 1) {
            return map[r][c];
        }

        if (isAllSame(r, c, size, map[r][c])) {
            return map[r][c];
        }

        int mid = size / 2;
        return "(" + search(r, c, mid) + search(r, c + mid, mid) + search(r + mid, c, mid) + search(r + mid, c + mid, mid) + ")";
    }

    public static boolean isAllSame(int r, int c, int size, String stand) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (!map[i][j].equals(stand)) {
                    return false;
                }
            }
        }
        return true;
    }
}
