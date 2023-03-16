package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 1;
        int number = 666;
        while (true) {
            if (count == n) {
                System.out.println(number);
                break;
            }
            number++;
            if (String.valueOf(number).indexOf("666") != -1) {
                count++;
            }
        }
    }
}
