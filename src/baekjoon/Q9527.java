package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q9527 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ab = br.readLine().split(" ");
        long a = Long.parseLong(ab[0]);
        long b = Long.parseLong(ab[1]);

        String aBinary = Long.toBinaryString(a - 1);
        String bBinary = Long.toBinaryString(b);
        int aLength = aBinary.length();
        int bLength = bBinary.length();

        int aTotal = a - 1 == 0 ? 0 : 1;
        for (int i = 0; i < aLength; i++) {
            if (aBinary.charAt(i) == '1') {
                int init = (int) Math.pow(2, aLength - i - 2);
                while (init >= 1) {
                    aTotal += init;
                    init /= 2;
                }
            }
        }

        int bTotal = b == 0 ? 0 : 1;
        for (int i = 0; i < bLength; i++) {
            if (bBinary.charAt(i) == '1') {
                int init = (int) Math.pow(2, bLength - i - 2);
                while (init >= 1) {
                    bTotal += init;
                    init /= 2;
                }
            }
        }

        System.out.println("aTotal = " + aTotal);
        System.out.println("bTotal = " + bTotal);
        System.out.println(bTotal - aTotal);
    }
}
