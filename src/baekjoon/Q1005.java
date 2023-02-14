package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1005 {

    private static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            testCase();
        }
    }

    private static void testCase() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] times = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        while (st.hasMoreTokens()) {
            times[count++] = Integer.parseInt(st.nextToken());
        }

        int[][] status = new int[n][n];
        int[][] graph = new int[n][n];
        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int prev = Integer.parseInt(input[0]);
            int next = Integer.parseInt(input[1]);
            status[next-1][prev-1] = -1;
            graph[prev-1][next-1] = times[prev-1];
        }

        for (int[] s : status) {
            System.out.println(Arrays.toString(s));
        }
        System.out.println();

        for (int[] g : graph) {
            System.out.println(Arrays.toString(g));
        }
    }
}
