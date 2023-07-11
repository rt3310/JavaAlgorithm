package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Q17140 {

    private static int r;
    private static int c;
    private static int k;
    private static int[][] map;

    private static int rowCount;
    private static int colCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[100][100];
        String[] rck = br.readLine().split(" ");
        r = Integer.parseInt(rck[0]);
        c = Integer.parseInt(rck[1]);
        k = Integer.parseInt(rck[2]);
        rowCount = 3;
        colCount = 3;

        for (int i = 0; i < 3; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        int count = 0;
        while (count <= 100) {
            if (map[r - 1][c - 1] == k) {
                System.out.println(count);
                return;
            }
            if (rowCount >= colCount) {
                rCalc();
            } else {
                cCalc();
            }
            count++;
        }
        System.out.println(-1);
    }

    private static void rCalc() {
        Map<Integer, Integer> counts;
        int prevColCount = colCount;
        colCount = 0;
        for (int i = 0; i < rowCount; i++) {
            counts = new HashMap<>();
            for (int j = 0; j < prevColCount; j++) {
                int value = map[i][j];
                if (value == 0) {
                    continue;
                }
                counts.put(value, counts.getOrDefault(value, 0) + 1);
            }

            List<Map.Entry<Integer, Integer>> result = counts.entrySet().stream()
                    .sorted((e1, e2) -> {
                        if (e1.getValue().equals(e2.getValue())) {
                            return e1.getKey() - e2.getKey();
                        }
                        return e1.getValue() - e2.getValue();
                    })
                    .collect(Collectors.toList());

            Arrays.fill(map[i], 0);
            int order = 0;
            for (Map.Entry<Integer, Integer> entry : result) {
                map[i][order] = entry.getKey();
                order++;
                map[i][order] = entry.getValue();
                order++;
                if (order >= 100) {
                    break;
                }
            }
            colCount = Math.max(colCount, order);
        }
    }

    private static void cCalc() {
        Map<Integer, Integer> counts;
        int prevRowCount = rowCount;
        rowCount = 0;
        for (int i = 0; i < colCount; i++) {
            counts = new HashMap<>();
            for (int j = 0; j < prevRowCount; j++) {
                int value = map[j][i];
                if (value == 0) {
                    continue;
                }
                counts.put(value, counts.getOrDefault(value, 0) + 1);
            }

            List<Map.Entry<Integer, Integer>> result = counts.entrySet().stream()
                    .sorted((e1, e2) -> {
                        if (e1.getValue().equals(e2.getValue())) {
                            return e1.getKey() - e2.getKey();
                        }
                        return e1.getValue() - e2.getValue();
                    })
                    .collect(Collectors.toList());

            for (int j = 0; j < 100; j++) {
                map[j][i] = 0;
            }
            int order = 0;
            for (Map.Entry<Integer, Integer> entry : result) {
                map[order][i] = entry.getKey();
                order++;
                map[order][i] = entry.getValue();
                order++;
                if (order >= 100) {
                    break;
                }
            }
            rowCount = Math.max(rowCount, order);
        }
    }
}
