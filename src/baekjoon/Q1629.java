package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        long c = Long.parseLong(input[2]);

        System.out.println(getMul(a, b, c));
    }

    public static long getMul(long num, long pow, long mod) {
        if (pow == 1) {
            return num % mod;
        }

        long value = getMul(num, pow / 2, mod);
        if (pow % 2 == 0) {
            return (value * value) % mod;
        }
        return (((value * value) % mod) * (num % mod)) % mod;
    }
}
