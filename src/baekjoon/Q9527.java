package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q9527 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ab = br.readLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);

        int total = 0;
        for (int i = a; i <= b; i++) {
            String binaryString = Integer.toBinaryString(i);
            System.out.println(i + " " + binaryString);
            char[] chars = binaryString.toCharArray();
            for (char c: chars) {
                if (c == '1') {
                    total++;
                }
            }
        }

        System.out.println(total);
    }
}
