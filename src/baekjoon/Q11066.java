package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11066 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static int[] files;
    private static int n;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            testcase();
        }

        System.out.print(sb);
    }

    public static void testcase() throws IOException {
        n = Integer.parseInt(br.readLine());
        files = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            files[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(search(0, n));
//        System.out.println(Arrays.toString(dp));
    }
    
    public static long search(int left, int right) {
        if (left == right) {
            return files[left];
        }

        long min = Integer.MAX_VALUE;
        for (int i = left + 1; i < right - 1; i++) {
            long l = search(left, i);
            long r = search(i, right);
            min = Math.min(min, (l + r) * 2);
        }
        return min;
    }
}
