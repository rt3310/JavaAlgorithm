package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3025 {

    private static int r;
    private static int c;
    private static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] rc = br.readLine().split(" ");
        r = Integer.parseInt(rc[0]);
        c = Integer.parseInt(rc[1]);
        map = new String[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().split("");
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int col = Integer.parseInt(br.readLine());
            throwStone(0, col - 1);
        }

        for (String[] r: map) {
            for (String d: r) {
                sb.append(d);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static boolean throwStone(int row, int col) {
        for (int i = row; i < r; i++) {
            if (i == r - 1 && map[i][col].equals(".")) {
                map[i][col] = "O";
                return true;
            }

            if (map[i][col].equals("X")) {
                map[i - 1][col] = "O";
                return true;
            }

            if (map[i][col].equals("O")) {
                if (col != 0 && map[i][col - 1].equals(".") && map[i - 1][col - 1].equals(".")) {
                    if (throwStone(i, col - 1)) {
                        return true;
                    }
                }

                if (col != c - 1 && map[i][col + 1].equals(".") && map[i - 1][col + 1].equals(".")) {
                    if (throwStone(i, col + 1)) {
                        return true;
                    }
                }

                map[i - 1][col] = "O";
                return true;
            }
        }
        return false;
    }
}
