package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q8382 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static int[][] directions;
    private static int x1, x2, y1, y2;
    private static int minCount;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");
            testcase();
        }

        System.out.print(sb);
    }

    private static void testcase() throws IOException {
        String[] xy = br.readLine().split(" ");
        x1 = Integer.parseInt(xy[0]);
        y1 = Integer.parseInt(xy[1]);
        x2 = Integer.parseInt(xy[2]);
        y2 = Integer.parseInt(xy[3]);

        minCount = Integer.MAX_VALUE;
        search(x1, y1, 0, 0);

        sb.append(minCount).append("\n");
    }

    private static void search(int x, int y, int startDirect, int count) {
        if (x == x2 && y == y2) {
            minCount = Math.min(minCount, count);
            return;
        }

        if (startDirect == 0) {
            if (x <= x2) {
                search(x + 1, y, 1, count + 1);
                return;
            }
            search(x - 1, y, 1, count + 1);
            return;
        }

        if (y <= y2) {
            search(x, y + 1, 0, count + 1);
            return;
        }
        search(x, y - 1, 0, count + 1);
    }
}
