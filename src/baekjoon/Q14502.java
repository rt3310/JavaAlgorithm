package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14502 {
    private static int n;
    private static int m;
    private static int[][] map;
    private static List<int[]> viruses;
    private static List<int[]> safes;
    private static int safeSize;
    private static int[] safePerm;
    private static int[][] directions;
    private static int maxSafeArea;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        map = new int[n][m];
        viruses = new ArrayList<>();
        safes = new ArrayList<>();
        safePerm = new int[3];
        directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        maxSafeArea = 0;

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            StringTokenizer st = new StringTokenizer(row);
            int j = 0;
            while (st.hasMoreTokens()) {
                int area = Integer.parseInt(st.nextToken());
                if (area == 0) {
                    safes.add(new int[]{i, j});
                }
                if (area == 2) {
                    viruses.add(new int[]{i, j});
                }
                map[i][j++] = area;
            }
        }
        safeSize = safes.size();

        for (int i = 0; i < safeSize; i++) {
            search(0, i);
        }

        System.out.println(maxSafeArea);
    }

    public static void search(int count, int start) {
        if (count == 3) {
            maxSafeArea = Math.max(maxSafeArea, spreadVirus());
            return;
        }

        for (int i = start; i < safeSize; i++) {
            safePerm[count] = i;
            search(count + 1, i + 1);
            safePerm[count] = 0;
        }
    }

    public static int spreadVirus() {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(map[i], m);
        }
        for (int i = 0; i < 3; i++) {
            int[] wall = safes.get(safePerm[i]);
            copy[wall[0]][wall[1]] = 1;
        }
        Deque<int[]> dq = new ArrayDeque<>(viruses);

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();

            for (int[] direction : directions) {
                int row = cur[0] + direction[0];
                int col = cur[1] + direction[1];

                if (row < 0 || row >= n || col < 0 || col >= m) {
                    continue;
                }

                if (copy[row][col] == 0) {
                    copy[row][col] = 2;
                    dq.offerLast(new int[]{row, col});
                }
            }
        }

        return countSafeArea(copy);
    }

    public static int countSafeArea(int[][] map) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}