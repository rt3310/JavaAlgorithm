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
                    length++;
                    continue;
                }
                if (map[i][j] == 0 && map[i][j + 1] != 0 && start != 0) {
                    if (length > 1) {
                        pq.offer(new int[]{start, map[i][j + 1], length});
                    }
                    start = 0;
                    length = 0;
                    continue;
                }
                if (start != 0 && map[j][i] == 0) {
                    length++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int start = 0;
            int length = 0;
            for (int j = 0; j < n - 1; j++) {
                if (map[j][i] != 0 && map[j + 1][i] == 0) {
                    start = map[j][i];
                    length++;
                    continue;
                }
                if (map[j][i] == 0 && map[j + 1][i] != 0 && start != 0) {
                    if (length > 1) {
                        pq.offer(new int[]{start, map[j + 1][i], length});
                    }
                    start = 0;
                    length = 0;
                    continue;
                }
                if (start != 0 && map[i][j] == 0) {
                    length++;
                }
            }
        }

        if (pq.isEmpty()) {
            System.out.println(-1);
            return;
        }

        parent = new int[count + 1];

        for (int i = 2; i <= count; i++) {
            parent[i] = i;
        }

        int total = 0;
        int edgeCount = 0;
        while (edgeCount < count - 3) {
            if (pq.isEmpty()) {
                System.out.println(-1);
                return;
            }
            int[] poll = pq.poll();
            int a = poll[0];
            int b = poll[1];
            int distance = poll[2];
            union(a, b);
            if (check) {
                total += distance;
                edgeCount++;
            }
        }

        System.out.println(total);
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
        a = getParent(a);
        b = getParent(b);

        if (a == b) {
            return;
        }
        parent[a] = b;
    }
}
