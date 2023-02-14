package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SquareRoom {

    private static BufferedReader br;
    private static int n;
    private static int[][] map;
    private static int maxDistance;
    private static List<int[]> list;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            testCase(i);
        }
    }

    public static void testCase(int testCount) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        maxDistance = 0;
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] rooms = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(rooms[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                search(new int[]{i, j}, new int[]{i, j}, 1);
            }
        }

        list.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        System.out.println("#" + testCount + " " + (list.get(0)[1]) + " " + (-list.get(0)[0]));
    }

    public static void search(int[] start, int[] cur, int count) {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        boolean isExist = false;
        for (int[] direction : directions) {
            int row = cur[0] + direction[0];
            int col = cur[1] + direction[1];

            if (row < 0 || row >= n || col < 0 || col >= n) {
                continue;
            }

            if (map[row][col] - map[cur[0]][cur[1]] == 1) {
                isExist = true;
                search(start, new int[]{row, col}, count + 1);
            }
        }

        if (!isExist && maxDistance <= count) {
            list.add(new int[]{-count, map[start[0]][start[1]]});
        }
    }
}
