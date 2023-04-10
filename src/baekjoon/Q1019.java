package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] count = new long[10];
        String n = br.readLine();
        int size = n.length();

        for (int i = 0; i < size - 1; i++) {
            int c = n.charAt(i) - 48;

            count[c] += Integer.parseInt(n.substring(i + 1)) + 1;
            int temp = c - 1;
            int pow = size - i - 1;
            while (temp > 0) {
                int pow1 = (int) Math.pow(10, pow);
                System.out.println("pow1 = " + pow1);
                count[temp] += pow1;
                temp--;
            }
        }

        int last = n.charAt(size - 1) - 48;
        for (int j = 1; j <= last; j++) {
            count[j] += 1;
        }

        if (Integer.parseInt(n) >= 10) {
            for (int i = 0; i < 10; i++) {
                count[i]++;
            }
        }
        System.out.println(Arrays.toString(count));
    }
}
