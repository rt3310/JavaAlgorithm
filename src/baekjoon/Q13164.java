package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] children = new int[n];
        int[] dp = new int[n];

        int count = 0;
        for (String child : br.readLine().split(" ")) {
            children[count++] = Integer.parseInt(child);
        }
    }
}
