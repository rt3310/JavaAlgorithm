package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q17281 {
    
    private static int n;
    private static int[][] hitters;
    private static int curHitter;
    private static boolean[] rue;
    private static int maxPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        hitters = new int[n + 1][10];
        curHitter = 1;
        rue = new boolean[4];
        maxPoint = 0;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                hitters[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[10];
        for (int i = 1; i < 10; i++) {
            int[] order = new int[10];
            order[1] = i;
            visited[i] = true;
            order[4] = 1;
            visited[1] = true;
            batchHitters(2, visited, order);
            visited[i] = false;
        }

        System.out.println(maxPoint);
    }

    public static void batchHitters(int count, boolean[] visited, int[] order) {
        if (count == 10) {
            maxPoint = Math.max(maxPoint, oneRound(order));
//            System.out.println(Arrays.toString(order));
            return;
        }

        if (count == 4) {
            batchHitters(count + 1, visited, order);
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (visited[i]) {
                continue;
            }
            order[count] = i;
            visited[i] = true;
            batchHitters(count + 1, visited, order);
            visited[i] = false;
        }
    }
    
    public static int oneRound(int[] hitterOrders) {
        int[][] curHitters = new int[n + 1][10];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 10; j++) {
                curHitters[i][j] = hitters[i][hitterOrders[j]];
            }
        }

        int outCount = 0;
        int order = -1;
        int point = 0;
        for (int i = 1; i <= n; i++) {
            while (outCount < 3) {
                order = (order + 1) % 9 + 1;
                int result = curHitters[i][order];
                if (result == 0) {
                    outCount++;
                    continue;
                }

                for (int j = 3; j > 0; j--) {
                    if (rue[j]) {
                        int moveCount = j + result;
                        rue[j] = false;
                        if (moveCount > 3) {
                            point++;
                            continue;
                        }
                        rue[moveCount] = true;
                    }
                }

                if (result == 4) {
                    point++;
                    continue;
                }
                rue[result] = true;
            }
        }
        return point;
    }
}
