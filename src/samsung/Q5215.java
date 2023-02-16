package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5215 {

    private static BufferedReader br;
    private static int[][] patties;
    private static int n;
    private static int l;
    private static int maxPoint;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            testCase(i);
        }

        System.out.println(sb);
    }

    private static void testCase(int testCount) throws IOException {
        String[] nl = br.readLine().split(" ");
        n = Integer.parseInt(nl[0]);
        l = Integer.parseInt(nl[1]);
        patties = new int[n][2];
        maxPoint = 0;

        for (int i = 0; i < n; i++) {
            String[] tk = br.readLine().split(" ");
            int t = Integer.parseInt(tk[0]);
            int k = Integer.parseInt(tk[1]);
            patties[i] = new int[]{t, k};
        }

        for (int i = 0; i < n; i++) {
            if (patties[i][1] > l) {
                continue;
            }

            search(0, patties[i][0], patties[i][1], i + 1);
        }

        sb.append("#" + testCount + " " + maxPoint).append("\n");
    }

    public static void search(int count, int point, int calorie, int start) {
        if (count == n) {
            maxPoint = Math.min(maxPoint, point);
            return;
        }

        for (int i = start; i < n; i++) {
            if (calorie + patties[i][1] > l) {
                continue;
            }
            search(count + 1, point + patties[i][0], calorie + patties[i][1], i + 1);
        }
        maxPoint = Math.max(maxPoint, point);
    }
}
