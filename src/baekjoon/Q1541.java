package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] strNumbers = input.split("-");

        int total = 0;
        StringTokenizer st = new StringTokenizer(strNumbers[0], "+");
        while (st.hasMoreTokens()) {
            total += Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < strNumbers.length; i++) {
            st = new StringTokenizer(strNumbers[i], "+");
            int subTotal = 0;
            while (st.hasMoreTokens()) {
                subTotal += Integer.parseInt(st.nextToken());
            }
            total -= subTotal;
        }

        System.out.println(total);
    }
}