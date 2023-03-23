package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s1 = br.readLine();
        String s2 = br.readLine();
        int s1Length = s1.length();
        int s2Length = s2.length();
        int[][] length = new int[s1Length + 1][s2Length + 1];

        int count = 1;
        for (int i = 1; i <= s1Length; i++) {
            for (int j = 1; j <= s2Length; j++) {
                length[i][j] = Math.max(length[i - 1][j], length[i][j - 1]);

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    length[i][j] = length[i - 1][j - 1] + 1;
                    if (length[i][j] == count) {
                        sb.append(s1.charAt(i - 1));
                        count++;
                    }
                }
            }
        }

        System.out.println(length[s1Length][s2Length]);

        if (length[s1Length][s2Length] > 0) {
            System.out.println(sb);
        }

        for (int[] row : length) {
            for (int v : row) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
