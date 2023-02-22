package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1868 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static int n;
    private static String[][] map;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            testCase();
        }
    }

    public static void testCase() throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
        }
    }

    public static void search() {
        
    }
}
