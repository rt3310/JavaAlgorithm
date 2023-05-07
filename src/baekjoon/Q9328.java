package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Q9328 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static int r;
    private static int c;
    private static char[][] map;
    private static Map<Character, Boolean> doors;
    private static int documents;
    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            testcase();
        }

        System.out.print(sb);
    }

    public static void testcase() throws IOException {
        String[] rc = br.readLine().split(" ");
        r = Integer.parseInt(rc[0]);
        c = Integer.parseInt(rc[1]);
        doors = new HashMap<>();
        documents = 0;
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        String keys = br.readLine();
        if (!keys.equals("0")) {
            char[] keysArray = keys.toCharArray();
            for (char key : keysArray) {
                doors.put((char)(key - 32), true);
            }
        }

        for (int i = 0; i < c; i++) {
            if (map[0][i] == '*') {
                continue;
            }

            if (map[0][i] >= 65 && map[0][i] <= 90) {
                if (!doors.containsKey(map[0][i])) {
                    continue;
                }
            }

            if (map[0][i] == '$') {
                documents++;
            }

            map[0][i] = '.';
            search(new int[]{0, i});
        }

        for (int i = 0; i < c; i++) {
            if (map[r - 1][i] == '*') {
                continue;
            }

            if (map[r - 1][i] >= 65 && map[r - 1][i] <= 90) {
                if (!doors.containsKey(map[r - 1][i])) {
                    continue;
                }
            }

            if (map[r - 1][i] == '$') {
                documents++;
            }

            map[r - 1][i] = '.';
            search(new int[]{r - 1, i});
        }

        for (int i = 0; i < r; i++) {
            if (map[i][0] == '*') {
                continue;
            }

            if (map[i][0] >= 65 && map[i][0] <= 90) {
                if (!doors.containsKey(map[i][0])) {
                    continue;
                }
            }

            if (map[i][0] == '$') {
                documents++;
            }

            map[i][0] = '.';
            search(new int[]{i, 0});
        }

        for (int i = 0; i < r; i++) {
            if (map[i][c - 1] == '*') {
                continue;
            }

            if (map[i][c - 1] >= 65 && map[i][c - 1] <= 90) {
                if (!doors.containsKey(map[i][c - 1])) {
                    continue;
                }
            }

            if (map[i][c - 1] == '$') {
                documents++;
            }

            map[i][c - 1] = '.';
            search(new int[]{i, c - 1});
        }

        System.out.println();
        for (char[] r : map) {
            for (char c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println(doors);

        sb.append(documents).append("\n");
    }

    public static void search(int[] start) {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];
        dq.offerLast(start);
        visited[start[0]][start[1]] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();

            for (int[] direction : directions) {
                int row = cur[0] + direction[0];
                int col = cur[1] + direction[1];

                if (row < 0 || row >= r || col < 0 || col >= c) {
                    continue;
                }

                if (map[row][col] == '*') {
                    continue;
                }

                if (visited[row][col]) {
                    continue;
                }

                if (map[row][col] == '$') {
                    documents++;
                    map[row][col] = '.';
                    visited[row][col] = true;
                    dq.offerLast(new int[]{row, col});
                    continue;
                }

                System.out.println("map[row][col] = " + map[row][col]);
                if (map[row][col] >= 97 && map[row][col] <= 122) {
                    doors.put((char) (map[row][col] - 32), true);
                    map[row][col] = '.';
                    visited[row][col] = true;
                    dq.offerLast(new int[]{row, col});
                    search(new int[]{row, col});
                    return;
                }

                if (!doors.containsKey(map[row][col])) {
                    continue;
                }

                map[row][col] = '.';
                visited[row][col] = true;
                dq.offerLast(new int[]{row, col});
            }
        }
    }
}
