package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q15686 {
    
    private static List<int[]> houses;
    private static List<int[]> chickens;
    private static boolean[] chickenVisited;
    private static int houseCount = 0;
    private static int chickenCount = 0;
    private static int m;
    private static int minTotalChickDistance;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        minTotalChickDistance = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                if (row[j - 1].equals("1")) {
                    houses.add(new int[]{i, j});
                    houseCount++;
                    continue;
                }
                if (row[j - 1].equals("2")) {
                    chickens.add(new int[]{i, j});
                    chickenCount++;
                }
            }
        }
        chickenVisited = new boolean[chickenCount];

        for (int i = 0; i < chickenCount; i++) {
            chickenVisited[i] = true;
            search(i + 1, 1);
            chickenVisited[i] = false;
        }
        System.out.println(minTotalChickDistance);
    }
    
    public static void search(int start, int count) {
        if (count == m) {
            calcDistances();
            return;
        }

        calcDistances();
        for (int i = start; i < chickenCount; i++) {
            chickenVisited[i] = true;
            search(i + 1, count + 1);
            chickenVisited[i] = false;
        }
    }

    public static void calcDistances() {
        int totalChickenDistance = 0;
        for (int i = 0; i < houseCount; i++) {
            int minChickenDistance = Integer.MAX_VALUE;
            for (int j = 0; j < chickenCount; j++) {
                if (!chickenVisited[j]) {
                    continue;
                }
                int[] housePos = houses.get(i);
                int[] chickenPos = chickens.get(j);
                minChickenDistance = Math.min(minChickenDistance, Math.abs(housePos[0] - chickenPos[0]) + Math.abs(housePos[1] - chickenPos[1]));
            }
            totalChickenDistance += minChickenDistance;
        }

        minTotalChickDistance = Math.min(minTotalChickDistance, totalChickenDistance);
    }
}
