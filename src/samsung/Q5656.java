package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q5656 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static int n;
    private static int w;
    private static int h;
    private static int[][] map;
    private static int min;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");
            testCase();
        }

        System.out.print(sb);
    }

    private static void testCase() throws IOException {
        String[] nwh = br.readLine().split(" ");
        n = Integer.parseInt(nwh[0]);
        w = Integer.parseInt(nwh[1]);
        h = Integer.parseInt(nwh[2]);
        map = new int[h][w];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < h; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, getCopyMap(map));
        sb.append(min).append("\n");
    }

    public static void search(int count, int[][] map) {
        if (count == n) {
            min = Math.min(min, getBlockCount(map));
            return;
        }

        for (int i = 0; i < w; i++) {
            search(count + 1, throwMarble(i, getCopyMap(map)));
        }
    }

    public static int[][] throwMarble(int col, int[][] map) {
        for (int i = 0; i < h; i++) {
            if (map[i][col] != 0) {
                boom(i, col, map);
                return resultMap(map);
            }
        }
        return map;
    }

    public static void boom(int row, int col, int[][] map) {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int boomLength = map[row][col];
        map[row][col] = 0;

        if (boomLength == 1) {
            return;
        }

        for (int[] direction: directions) {
            int curRow = row;
            int curCol = col;
            for (int i = 1; i < boomLength; i++) {
                curRow += direction[0];
                curCol += direction[1];

                if (curRow < 0 || curRow >= h || curCol < 0 || curCol >= w) {
                    break;
                }

                if (map[curRow][curCol] > 0) {
                    boom(curRow, curCol, map);
                }
            }
        }
    }

    public static int[][] resultMap(int[][] map) {
        int[][] copy = new int[h][w];

        for (int i = 0; i < w; i++) {
            int rowCount = h - 1;
            for (int j = h - 1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    copy[rowCount--][i] = map[j][i];
                }
            }
        }

        return copy;
    }

    private static int[][] getCopyMap(int[][] map) {
        int[][] copyMap = new int[h][w];
        for (int j = 0; j < h; j++) {
            copyMap[j] = Arrays.copyOf(map[j], w);
        }
        return copyMap;
    }

    public static int getBlockCount(int[][] map) {
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
