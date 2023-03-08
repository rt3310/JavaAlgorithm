package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int end = m - 3;
        int count = 0;
        int total = 0;
        int i = 0;
        while (i <= end) {
            if (s.startsWith("IOI", i)) {
                count++;
                i += 2;
                continue;
            }

            if (count >= n) {
                total += count - n + 1;
            }
            count = 0;
            i++;
        }

        if (count >= n) {
            total += count - n + 1;
        }

        System.out.println(total);
    }
}
