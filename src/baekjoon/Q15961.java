package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q15961 {

    private static int n;
    private static int d;
    private static int k;
    private static int c;
    private static int[] belt;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        d = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        c = Integer.parseInt(input[3]);
        belt = new int[n];

        for (int i = 0; i < n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        int maxCount = 0;
        while (idx < n) {
            int count = 0;
            int coupon = -1;
            check = new boolean[d + 1];
            for (int j = idx; j < idx + k; j++) {
                if (belt[j % n] == c) {
                    check[belt[j % n]] = true;
                    coupon = j;
                }
                if (!check[belt[j % n]]) {
                    check[belt[j % n]] = true;
                    count++;
                }
            }

            maxCount = Math.max(maxCount, count);

            if (coupon != -1) {
                if (coupon >= n) {
                    break;
                }
                idx = coupon + 1;
                continue;
            }
            idx++;
        }

        System.out.println(maxCount + 1);
    }
}
