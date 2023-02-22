package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2112 {

    private static BufferedReader br;
    private static int d;
    private static int w;
    private static int k;
    private static int[][] film;
    private static boolean[] visitedA;
    public static boolean[] visitedB;
    private static int minCount;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            testCase(i);
        }
        System.out.print(sb);
    }

    public static void testCase(int testCount) throws IOException {
        String[] dwk = br.readLine().split(" ");
        d = Integer.parseInt(dwk[0]);
        w = Integer.parseInt(dwk[1]);
        k = Integer.parseInt(dwk[2]);
        visitedA = new boolean[d];
        visitedB = new boolean[d];
        minCount = Integer.MAX_VALUE;
        film = new int[d][w];

        for (int i = 0; i < d; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                film[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 0);
        sb.append("#").append(testCount).append(" ").append(minCount).append("\n");
    }

    public static void search(int start, int count) {
        if (count == k + 1) {
            return;
        }

        if (checkPerformance()) {
            minCount = Math.min(minCount, count);
        }

        for (int i = start; i < d; i++) {
            if (!visitedA[i]) {
                visitedA[i] = true;
                search(i + 1, count + 1);
                visitedA[i] = false;
            }
            if (!visitedB[i]) {
                visitedB[i] = true;
                search(i + 1, count + 1);
                visitedB[i] = false;
            }
        }
    }
    
    public static boolean checkPerformance() {
        for (int i = 0; i < w; i++) {
            int stand = film[0][i];
            if (visitedA[0]) {
                stand = 0;
            }
            if (visitedB[0]) {
                stand = 1;
            }
            int count = 1;
            boolean isValid = false;
            for (int j = 1; j <= d; j++) {
                if (count >= k) {
                    isValid = true;
                    break;
                }

                if (j >= d) {
                    break;
                }

                if (visitedA[j]) {
                    if (stand == 0) {
                        count++;
                        continue;
                    }
                    stand = 0;
                    count = 1;
                    continue;
                }

                if (visitedB[j]) {
                    if (stand == 1) {
                        count++;
                        continue;
                    }
                    stand = 1;
                    count = 1;
                    continue;
                }

                if (film[j][i] != stand) {
                    stand = film[j][i];
                    count = 1;
                    continue;
                }
                count++;
            }

            if (!isValid) {
                return false;
            }
        }
        return true;
    }
}
