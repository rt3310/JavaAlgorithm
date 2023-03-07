//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Arrays;
//import java.util.Deque;
//import java.util.StringTokenizer;
//
//public class Q16236 {
//
//    private static int n;
//    private static int[][] map;
//    private static int curSize;
//    private static int time;
//    private static int eatCount;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        n = Integer.parseInt(br.readLine());
//        map = new int[n][n];
//        curSize = 2;
//        time = 0;
//        eatCount = 0;
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < n; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//                if (map[i][j] == 9) {
//                    map[i][j] = 0;
//                    shark = new int[]{i, j};
//                }
//            }
//        }
//        search(new int[]{shark[0], shark[1], 0});
//        System.out.println(time);
//    }
//
//    public static void search(int[] start) {
//        boolean[][] visited = new boolean[n][n];
//        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
//        Deque<int[]> q = new ArrayDeque<>();
//        q.offerLast(start);
//        visited[start[0]][start[1]] = true;
//
//        while (!q.isEmpty()) {
//            int[] cur = q.pollFirst();
//
//            for (int[] direction : directions) {
//                int row = cur[0] + direction[0];
//                int col = cur[1] + direction[1];
//
//                if (row < 0 || row >= n || col < 0 || col >= n) {
//                    continue;
//                }
//
//                if (visited[row][col]) {
//                    continue;
//                }
//
//                if (map[row][col] > curSize) {
//                    continue;
//                }
//
//                visited[row][col] = true;
//                q.offerLast(new int[]{row, col, cur[2] + 1});
//
//                if (map[row][col] != 0 && map[row][col] < curSize) {
//                    eatCount++;
//                    map[row][col] = 0;
//
//                    if (eatCount == curSize) {
//                        curSize++;
//                        eatCount = 0;
//                    }
//                    time = Math.max(time, cur[2] + 1);
//                    search(new int[]{row, col, cur[2] + 1});
//                }
//            }
//            showMap();
//            System.out.println("curSize = " + curSize);
//        }
//    }
//
//
//    public static void showMap() {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (shark[0] == i && shark[1] == j) {
//                    System.out.print("@ ");
//                    continue;
//                }
//                System.out.print(map[i][j] == 0 ? ". " : map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
//}
