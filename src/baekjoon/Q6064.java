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
            int m = Integer.parseInt(nmxy[0]);
            int n = Integer.parseInt(nmxy[1]);
            int x = Integer.parseInt(nmxy[2]);
            int y = Integer.parseInt(nmxy[3]);
            int gcd;
            if (m > n) {
                gcd = gcd(m, n);
            } else {
                gcd = gcd(n, m);
            }
            int lcm = m * n / gcd;

            int tempx = x;
            int tempy = x;
            boolean seek = false;
            while (tempx <= lcm) {
                tempy = tempx % n == 0 ? n : tempx % n;
                if (tempy == y) {
                    seek = true;
                    break;
                }
                tempx += m;
                tempy %= n;
            }

            sb.append(seek ? tempx : -1).append("\n");
        }

        System.out.print(sb);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
