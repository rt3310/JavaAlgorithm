package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q9375 {
    private static BufferedReader br;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            testCase();
        }

        System.out.print(sb);
    }

    public static void testCase() throws IOException {
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            map.put(input[1], map.getOrDefault(input[1], 0) + 1);
        }

        int total = 1;
        for (int count : map.values()) {
            total *= count + 1;
        }

        sb.append(total - 1).append("\n");
    }
}
