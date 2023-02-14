package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q10026 {

    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[][] map = new String[n][n];
        String[][] map2 = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = inputs[j];
                map2[i][j] = inputs[j];
            }
        }

        int count = 0;
        int weaknessCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("0")) {
                    continue;
                }
                search(map, new int[]{i, j}, false);
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map2[i][j].equals("0")) {
                    continue;
                }
                search(map2, new int[]{i, j}, true);
                weaknessCount++;
            }
        }
        System.out.println(count + " " + weaknessCount);
    }

    public static void search(String[][] map, int[] start, boolean isWeakness) {
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Deque<int[]> q = new ArrayDeque<>();
        String stand = map[start[0]][start[1]];
        map[start[0]][start[1]] = "0";
        q.offerLast(start);

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();

            for (int[] d : direction) {
                int row = cur[0] + d[0];
                int col = cur[1] + d[1];

                if (row < 0 || row >= n || col < 0 || col >= n) {
                    continue;
                }

                if (map[row][col].equals("0")) {
                    continue;
                }

                if (isWeakness) {
                    if (stand.equals("G") || stand.equals("R")) {
                        if (!map[row][col].equals("G") && !map[row][col].equals("R")) {
                            continue;
                        }
                    } else {
                        if (!map[row][col].equals(stand)) {
                            continue;
                        }
                    }
                } else {
                    if (!map[row][col].equals(stand)) {
                        continue;
                    }
                }

                map[row][col] = "0";
                q.offerLast(new int[]{row, col});
            }
        }
    }
}
