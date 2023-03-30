package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11401 {

    public static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        long nTotal = 1;
        for (int i = n; i > 0; i--) {
            nTotal *= i;
            nTotal %= MOD;
        }

        long kTotal = 1;
        for (int i = k; i > 0; i--) {
            kTotal *= i;
            kTotal %= MOD;
        }

        for (int i = n - k; i > 0; i--) {
            kTotal *= i;
            kTotal %= MOD;
        }

        long answer = 1;
        long x = kTotal;
        long y = MOD - 2;
        while (y > 0) {
            if (y % 2 != 0) {
                answer *= x;
                answer %= MOD;
            }
            x *= x;
            x %= MOD;
            y /= 2;
        }

        System.out.println((nTotal * (answer % MOD)) % MOD);
    }
}
