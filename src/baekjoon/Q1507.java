package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Q1507 {

    private static int[][] map;
    private static boolean[][] shortest;
    private static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        shortest = new boolean[n][n];
        total = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (j == k || i == k) {
                        continue;
                    }

                    if (map[j][k] == map[j][i] + map[i][k]) {
                        shortest[j][k] = true;
                        continue;
                    }

                    if (map[j][k] > map[j][i] + map[i][k]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (!shortest[i][j]) {
                    total += map[i][j];
                }
            }
        }

        System.out.println(total);
    }
}
