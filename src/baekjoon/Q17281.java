package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17281 {
    
    private static int n;
    private static int[][] hitters;
    private static int maxPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        hitters = new int[n + 1][10];
        maxPoint = 0;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                hitters[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[10];
        int[] order = new int[10];
        order[4] = 1;
        visited[1] = true;
        for (int i = 2; i < 10; i++) {
            order[1] = i;
            visited[i] = true;
            batchHitters(2, visited, order);
            visited[i] = false;
        }

        System.out.println(maxPoint);
    }

    public static void batchHitters(int count, boolean[] visited, int[] order) {
        if (count == 10) {
            maxPoint = Math.max(maxPoint, innings(order));
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
    
    public static int innings(int[] hitterOrders) {
        int order = 1;
        int point = 0;
        for (int i = 1; i <= n; i++) {
            int outCount = 0;
            boolean[] rue = new boolean[4];
            while (outCount < 3) {
                int result = hitters[i][hitterOrders[order]];
                order = order % 9 + 1;
                if (result == 0) {
                    outCount++;
                    continue;
                }

                for (int j = 3; j > 0; j--) {
                    if (rue[j]) {
                        rue[j] = false;
                        int next = j + result;
                        if (next > 3) {
                            point++;
                            continue;
                        }
                        rue[next] = true;
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
