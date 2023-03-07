package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2115 {
    private static BufferedReader br;
    private static StringBuilder sb;
    private static int n;
    private static int m;
    private static int c;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            testCase();
        }
    }

    private static void testCase() throws IOException  {
        String[] nmc = br.readLine().split(" ");
        n = Integer.parseInt(nmc[0]);
        m = Integer.parseInt(nmc[1]);
        c = Integer.parseInt(nmc[2]);
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 0, new ArrayList<>());
    }

    public static void search(int count, int start, List<Integer> arr) {
        if (count == 2) {
            System.out.println(arr);
            return;
        }

        for (int i = start; i < n; i++) {
            arr.add(i);
            search(count + 1, i + 1, arr);
            arr.remove(-1);
        }
    }
}
