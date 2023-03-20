package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q11444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n = new BigInteger(br.readLine());
        long pp = 0;
        long p = 1;
        long cur = 1;
        for (BigInteger i = BigInteger.ONE; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
            cur = ((pp % 1000000007) + (p % 1000000007)) % 1000000007;
            pp = p;
            p = cur;
        }

        System.out.println(cur);
    }
}
