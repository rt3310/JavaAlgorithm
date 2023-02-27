package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17472 {

    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] parent;
    private static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        map = new int[n][m];
        visited = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    map[i][j] = count;
                    search(new int[]{i, j}, count++);
                }
            }
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[2]));

        for (int i = 0; i < n; i++) {
            int start = 0;
            int length = 0;
            for (int j = 0; j < m - 1; j++) {
                if (map[i][j] != 0 && map[i][j + 1] == 0) {
                    start = map[i][j];
                    continue;
                }
                if (map[i][j] == 0 && map[i][j + 1] != 0 && length > 1 && start != 0) {
                    pq.add(new int[]{start, map[i][j + 1], length});
                    continue;
                }
                length++;
            }
        }

        for (int i = 0; i < m; i++) {
            int start = 0;
            int length = 0;
            for (int j = 0; j < n - 1; j++) {
                if (map[j][i] != 0 && map[j + 1][i] == 0) {
                    start = map[j][i];
                    continue;
                }
                if (map[j][i] == 0 && map[j + 1][i] != 0 && length > 1 && start != 0) {
                    pq.add(new int[]{start, map[j + 1][i], length});
                    continue;
                }
                length++;
            }
        }

        parent = new int[count + 1];

        for (int i = 2; i <= count; i++) {
            parent[i] = i;
        }

        pq.forEach(e -> System.out.println(Arrays.toString(e)));

    }

    public static void search(int[] start, int count) {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(start);
        visited[start[0]][start[1]] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();

            for (int[] direction : directions) {
                int row = cur[0] + direction[0];
                int col = cur[1] + direction[1];

                if (row < 0 || row >= n || col < 0 || col >= m) {
                    continue;
                }

                if (visited[row][col]) {
                    continue;
                }

                if (map[row][col] == 0) {
                    continue;
                }

                visited[row][col] = true;
                map[row][col] = count;
                dq.offerLast(new int[]{row, col});
            }
        }
    }

    public static int getParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = getParent(parent[x]);
    }

    public static void union(int a, int b) {
        check = false;
        a = getParent(a);
        b = getParent(b);

        if (a == b) {
            return;
        }
        parent[a] = b;
        check = true;
    }
}
