package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11050 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int count = n;
        int total = 1;
        for (int i = 0; i < k; i++) {
            total *= count--;
        }

        for (int i = 1; i <= k; i++) {
            total /= i;
        }

        System.out.println(total);
    }
}
