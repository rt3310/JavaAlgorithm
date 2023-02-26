package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q17135 {

    private static int n;
    private static int m;
    private static int d;
    private static int enemyCount;
    private static int killCount;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] archerCol;
    private static int[][] directions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmd = br.readLine().split(" ");
        n = Integer.parseInt(nmd[0]);
        m = Integer.parseInt(nmd[1]);
        d = Integer.parseInt(nmd[2]);
        map = new int[n][m];
        archerCol = new int[3];
        directions = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        killCount = 0;
        enemyCount = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    enemyCount++;
                }
                map[i][j] = value;
            }
        }

        for (int i = 0; i < n; i++) {
            startRound(i);
        }
    }

    public static void startRound(int round) {
        for (int i = 0; i < m; i++) {
            search(i, 0, new int[3], round);
        }
    }
    
    

    public static void search(int start, int count, int[] archerCol, int round) {
        if (count == 3) {
            for (int i = 0; i < 3; i++) {
                shooting(new int[]{n - round, archerCol[i]});
            }
            return;
        }

        archerCol[count] = start;
        for (int i = start; i < m; i++) {
            search(i + 1, count + 1, archerCol, round);
        }
    }

    public static void shooting(int[] start) {
        int[][] newMap = getNewMap();
        visited = new boolean[n][m];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(start);

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();

            for (int[] direction : directions) {
                int row = cur[0] + direction[0];
                int col = cur[1] + direction[1];

                if (row < 0 || row >= n || col < 0 || col >= m) {
                    continue;
                }
            }
        }
    }

    private static int[][] getNewMap() {
        int[][] copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(map[i], m);
        }

        return copy;
    }
}
