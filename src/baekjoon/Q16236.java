package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q16236 {

    private static int n;

    private static int[] shark;
    private static int[][] map;
    private static boolean[][] visited;
    private static int curSize;
    private static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        curSize = 2;
        time = 0;

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 0; j < n; j++) {
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    shark = new int[]{i, j};
                    break;
                }
            }
        }

        search();
        System.out.println(time);
    }

    public static void search() {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{shark[0], shark[1]});
        visited[shark[0]][shark[1]] = true;

        int eatCount = 0;
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();

            boolean eated = false;
            for (int[] direction : directions) {
                int row = cur[0] + direction[0];
                int col = cur[1] + direction[1];

                if (row < 0 || row >= n || col < 0 || col >= n) {
                    continue;
                }

                if (visited[row][col]) {
                    continue;
                }

                if (map[row][col] > curSize) {
                    continue;
                }

                if (map[row][col] != 0 && map[row][col] < curSize) {
                    eatCount++;
                    time += Math.abs(shark[0] - row) + Math.abs(shark[1] - col);
                    map[row][col] = 0;
                    shark = new int[]{row, col};
                    System.out.println(time);
                    eated = true;

                    if (eatCount == curSize) {
                        curSize++;
                        eatCount = 0;
                    }
                }

                visited[row][col] = true;
                q.offerLast(new int[]{row, col});
            }

            if (eated) {
                visited = new boolean[n][n];
                visited[shark[0]][shark[1]] = true;
                q.clear();
                q.offerLast(new int[]{shark[0], shark[1]});
                for (int[] qq: q) {
                    System.out.print(Arrays.toString(qq) + " ");
                }
            }
            showMap();
            System.out.println();
        }
    }

    public static void showVisited() {
        for (boolean[] r : visited) {
            for (boolean d : r) {
                System.out.print(d ? "O " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void showMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (shark[0] == i && shark[1] == j) {
                    System.out.print("@ ");
                    continue;
                }
                System.out.print(map[i][j] == 0 ? ". " : map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
