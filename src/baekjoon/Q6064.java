package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6064 {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] nmxy = br.readLine().split(" ");
            int n = Integer.parseInt(nmxy[0]);
            int m = Integer.parseInt(nmxy[1]);
            int x = Integer.parseInt(nmxy[2]);
            int y = Integer.parseInt(nmxy[3]);

            if (n == m) {
                if (x != y) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(x);
                continue;
            }
        }
        System.out.println(sb);
    }
}
