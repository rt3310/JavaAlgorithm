package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q21611 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] blizzardDirections = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int[][] moveDirections = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private static int[] boomCounts = {0, 0, 0};
    private static List<Integer> marbles = new ArrayList<>();
    private static int n, m;
    private static int[][] map;
    
    public static void main(String[] args) throws IOException {
        input();
        int straightDistance = 1;
        int straightCount = 0;
        int turnCount = 0;
        int curRow = n / 2;
        int curCol = n / 2;
        int curDirection = 0;
        while (true) {
            curRow += moveDirections[curDirection][0];
            curCol += moveDirections[curDirection][1];
            if (map[curRow][curCol] == 0) {
                break;
            }
            marbles.add(map[curRow][curCol]);

            if (curRow == 0 && curCol == 0) {
                break;
            }

            straightCount++;
            if (straightCount == straightDistance) {
                straightCount = 0;
                curDirection = (curDirection + 1) % 4;
                turnCount++;
                if (turnCount == 2) {
                    turnCount = 0;
                    straightDistance++;
                }
            }
        }
        System.out.println(marbles);
//        blizzard();
    }

    private static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }
    }

    private static void blizzard() throws IOException {
        int mid = n / 2;
        for (int i = 0; i < m; i++) {
            String[] blizzard = br.readLine().split(" ");
            int direction = Integer.parseInt(blizzard[0]) - 1;
            int distance = Integer.parseInt(blizzard[1]);

            int curRow = mid;
            int curCol = mid;
            for (int j = 0; j < distance; j++) {
                curRow += blizzardDirections[direction][0];
                curCol += blizzardDirections[direction][1];
                map[curRow][curCol] = '0';
            }
        }
    }
}
