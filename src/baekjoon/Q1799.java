package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1799 {

    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static boolean[][] evenVisited;
    private static int[][] directions = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    private static int oddMax;
    private static int evenMax;

    enum Block {
        EVEN, ODD
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        oddMax = 0;
        evenMax = 0;
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        search(0, 0, 0, Block.ODD);
        visited = new boolean[n][n];
        search(0, 0, 1, Block.EVEN);
        System.out.println(oddMax + evenMax);
    }

    public static void search(int order, int r, int c, Block block) {
        if (block.equals(Block.ODD)) {
            oddMax = Math.max(oddMax, order);
        } else {
            evenMax = Math.max(evenMax, order);
        }

        if (c >= n) {
            r++;
            if (block.equals(Block.ODD)) {
                c = r % 2 == 0 ? 0 : 1;
            } else {
                c = r % 2 == 0 ? 1 : 0;
            }
        }

        if (r >= n) {
            return;
        }

        if (canPut(r, c)) {
            visited[r][c] = true;
            search(order + 1, r, c + 2, block);
            visited[r][c] = false;
        }
        search(order, r, c + 2, block);
    }

    public static boolean canPut(int r, int c) {
        if (map[r][c] == 0) {
            return false;
        }

        for (int[] direction : directions) {
            int nr = direction[1] + r;
            int nc = direction[0] + c;

            for (int i = 0; i < n; i++) {
                if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                    continue;
                }

                if (visited[nr][nc]) {
                    return false;
                }

                nr += direction[1];
                nc += direction[0];
            }
        }

        return true;
    }
}
