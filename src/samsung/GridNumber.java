package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class GridNumber {

    private static BufferedReader br;
    private static String[][] map;
    private static Set<String> result;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            testCase(i);
        }
    }

    public static void testCase(int count) throws IOException {
        map = new String[4][4];
        result = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            map[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                search(new int[]{i, j}, 1, map[i][j]);
            }
        }

        System.out.println("#" + count + " " + result.size());
    }

    public static void search(int[] cur, int count, String number) {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        if (count == 7) {
            result.add(number);
            return;
        }

        for (int[] direction : directions) {
            int row = cur[0] + direction[0];
            int col = cur[1] + direction[1];

            if (row < 0 || row >= 4 || col < 0 || col >= 4) {
                continue;
            }

            search(new int[]{row, col}, count + 1, number + map[row][col]);
        }
    }
}
