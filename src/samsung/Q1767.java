package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1767 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static int n;
    private static int[][] processor;
    private static List<int[]> cores;
    private static int maxCoreCount;
    private static int minDistance;
    private static int[][] directions;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");
            testcase();
        }

        System.out.println(sb);
    }

    public static void testcase() throws IOException {
        n = Integer.parseInt(br.readLine());
        processor = new int[n][n];
        cores = new ArrayList<>();
        maxCoreCount = 0;
        minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                processor[i][j] = Integer.parseInt(st.nextToken());
                if (processor[i][j] == 1 && i != 0 && i != n - 1 && j != 0 && j != n - 1) {
                    cores.add(new int[]{i, j});
                }
            }
        }


        search(0, 0, 0);
        sb.append(minDistance).append("\n");
    }

    public static void search(int cur, int total, int count) {
        if (cur == cores.size()) {
            if (count >= maxCoreCount) {
                if (count == maxCoreCount && total > minDistance) {
                    return;
                }
                maxCoreCount = count;
                minDistance = total;
            }
            return;
        }

        boolean isZero = false;
        for (int j = 0; j < 4; j++) {
            int distance = searchPower(cur, directions[j]);
            if (distance == 0) {
                isZero = true;
                continue;
            }
            search(cur + 1, total + distance, count + 1);
            disconnect(cores.get(cur)[0], cores.get(cur)[1], directions[j]);
        }
        if (isZero) {
            search(cur + 1, total, count);
        }
    }

    public static int searchPower(int cur, int[] direction) {
        int startRow = cores.get(cur)[0];
        int startCol = cores.get(cur)[1];
        int curRow = startRow + direction[0];
        int curCol = startCol + direction[1];

        int distance = 0;
        while (true) {
            if (curRow < 0 || curRow >= n || curCol < 0 || curCol >= n) {
                connect(startRow, startCol, direction);
                return distance;
            }

            if (processor[curRow][curCol] > 0) {
                return 0;
            }

            curRow += direction[0];
            curCol += direction[1];
            distance++;
        }
    }

    public static void connect(int startRow, int startCol, int[] direction) {
        int curRow = startRow + direction[0];
        int curCol = startCol + direction[1];
        while (curRow >= 0 && curRow < n && curCol >= 0 && curCol < n) {
            processor[curRow][curCol] = 2;

            curRow += direction[0];
            curCol += direction[1];
        }
    }

    public static void disconnect(int startRow, int startCol, int[] direction) {
        int curRow = startRow + direction[0];
        int curCol = startCol + direction[1];
        while (curRow >= 0 && curRow < n && curCol >= 0 && curCol < n) {
            if (processor[curRow][curCol] == 2) {
                processor[curRow][curCol] = 0;
            }

            curRow += direction[0];
            curCol += direction[1];
        }
    }
}
