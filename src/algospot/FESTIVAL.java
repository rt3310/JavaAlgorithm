package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FESTIVAL {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static int n;
    private static int[] arr;
    private static double minAvg;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            testCase();
        }

        System.out.print(sb);
    }

    private static void testCase() throws IOException {
        String[] nl = br.readLine().split(" ");
        n = Integer.parseInt(nl[0]);
        int l = Integer.parseInt(nl[1]);
        arr = new int[n];
        minAvg = Double.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = l; i <= n; i++) {
            int total = 0;
            for (int j = 0; j < i; j++) {
                total += arr[j];
            }
            search(total, 0, i - 1, i);
        }

        sb.append(String.format("%.11f", minAvg)).append("\n");
    }

    public static void search(int total, int left, int right, int windowSize) {
        while (true) {
            minAvg = Math.min(minAvg, (double) total / windowSize);

            total -= arr[left];
            left++;
            right++;

            if (right >= n) {
                return;
            }

            total += arr[right];
        }
    }
}
