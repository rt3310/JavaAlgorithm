package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TSP {

    private static int n;
    private static int[][] map;
    private static int[][] dp;
    private static final int INF = 11_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][(1 << n) - 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(search(0, 1));
    }

    /**
     *
     * @param city: 현재 위치한 도시 인덱스
     * @param visitBitMask: 지금까지 방문한 도시 이진수
     * @return
     */
    public static int search(int city, int visitBitMask) {
        // 모든 도시를 방문했다면
        if (visitBitMask == (1 << n) - 1) {
            if (map[city][0] > 0) {
                return map[city][0]; // 현재 도시 -> 0번째(시작) 도시 이동 거리
            }
            return INF;
        }

        if (dp[city][visitBitMask] != -1) { // dp 값이 존재하는 경우
            return dp[city][visitBitMask];
        }

        dp[city][visitBitMask] = INF;
        for (int i = 0; i < n; i++) { // 현재 도시(city)에서 각 i의 도시로 이동한 경우에 대해 dfs 수행
            if (i == city) {
                continue;
            }

            if ((visitBitMask & (1 << i)) == 0 && map[city][i] > 0) { // 방문하지 않았던 도시
                // 다음 도시까지 거리와 최소거리 비교
                dp[city][visitBitMask] = Math.min(dp[city][visitBitMask], search(i, visitBitMask | (1 << i)) + map[city][i]);
            }
        }
        return dp[city][visitBitMask];
    }
}
