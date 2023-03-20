package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long n = Long.parseLong(input[0]);
        long r = Long.parseLong(input[1]);
        long m = Long.parseLong(input[2]);

        long cur = n % m;
        long idx = 0;
        while (idx * 2 + 1 <= r) {
            cur = (cur * cur) % m;
            idx = (idx * 2) + 1;
        }

        for (long i = idx + 1; i <= r; i++) {
            cur = (cur * (n % m)) % m;
        }

        System.out.println(cur % m);
    }
}
