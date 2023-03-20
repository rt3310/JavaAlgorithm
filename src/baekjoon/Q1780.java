package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1780 {

    private static Map<Integer, Integer> counts;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        counts = new HashMap<>();
        counts.put(0, 0);
        counts.put(1, 0);
        counts.put(-1, 0);

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 0, n);
        System.out.println(counts.get(-1));
        System.out.println(counts.get(0));
        System.out.println(counts.get(1));
    }

    public static void search(int row, int col, int size) {
        int stand = map[row][col];

        if (size == 1) {
            counts.put(stand, counts.get(stand) + 1);
            return;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[row + i][col + j] != stand) {
                    int nextSize = size / 3;
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            search(row + (nextSize * k), col + (nextSize * l), nextSize);
                        }
                    }
                    return;
                }
            }
        }

        counts.put(stand, counts.get(stand) + 1);
    }
}