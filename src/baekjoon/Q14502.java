package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q14502 {
    private static int n;
    private static int m;
    private static String[][] map;
    private static List<int[]> viruses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        map = new String[n][m];
        viruses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            StringTokenizer st = new StringTokenizer(row, " ");
            int j = 0;
            while (st.hasMoreTokens()) {
                String area = st.nextToken();
                if (area.equals("2")) {
                    viruses.add(new int[]{i, j});
                }
                map[i][j++] = area;
            }
        }

        do {
            if (checkWall()) {
                System.out.println(countSafeArea());
                return;
            }

            for (String[] row : map) {
                for (String dot : row) {
                    System.out.print(dot + " ");
                }
                System.out.println();
            }
            System.out.println();
        } while (spreadVirus());
    }

    public static boolean spreadVirus() {
        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        List<int[]> newViruses = new ArrayList<>();

        for (int[] virus : viruses) {
            for (int[] direction : directions) {
                int row = virus[0] + direction[0];
                int col = virus[1] + direction[1];

                if (row < 0 || row >= n || col < 0 || col >= m) {
                    continue;
                }

                if (map[row][col].equals("0")) {
                    map[row][col] = "2";
                    newViruses.add(new int[]{row, col});
                }
            }
        }

        viruses = newViruses;

        return viruses.size() != 0;
    }

    public static boolean checkWall() {
        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        boolean[][] visited = new boolean[n][m];

        int count = 0;
        for (int[] virus : viruses) {
            for (int[] direction : directions) {
                int row = virus[0] + direction[0];
                int col = virus[1] + direction[1];

                if (row < 0 || row >= n || col < 0 || col >= m) {
                    continue;
                }

                if (visited[row][col]) {
                    continue;
                }

                if (map[row][col].equals("0")) {
                    visited[row][col] = true;
                    count++;
                }
            }
        }

        return count == 3;
    }

    public static int countSafeArea() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("0")) {
                    count++;
                }
            }
        }

        return count;
    }
}