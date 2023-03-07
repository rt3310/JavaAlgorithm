package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q2407 {

    private static int n;
    private static int r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);

        System.out.println(fibo(BigInteger.valueOf(n), r).divide(fibo(BigInteger.valueOf(r), r)));
    }

    public static BigInteger fibo(BigInteger n, int count) {
        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }

        if (count == 1) {
            return n;
        }

        return n.multiply(fibo(n.subtract(BigInteger.ONE), count - 1));
    }
}
