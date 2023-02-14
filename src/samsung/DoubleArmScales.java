package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class DoubleArmScales {

    private static BufferedReader br;
    private static int n;
    private static int total;
    private static Map<Integer, Integer> visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            testCase(i);
        }
    }

    public static void testCase(int testCount) throws IOException {
        total = 0;
        n = Integer.parseInt(br.readLine());
        visited = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            int weight = Integer.parseInt(st.nextToken());
            visited.put(weight, visited.getOrDefault(weight, 0) + 1);
        }

        for (int key: visited.keySet()) {
            if (visited.get(key) > 0) {
                visited.put(key, visited.get(key) - 1);
                search(1, 0, key);
                visited.put(key, visited.get(key) + 1);
            }
        }

        System.out.println("#" + testCount + " " + total);
    }

    public static void search(int count, int left, int right) {
        if (count == n && left <= right) {
            total++;
            return;
        }

        for (int key: visited.keySet()) {
            if (visited.get(key) > 0) {
                visited.put(key, visited.get(key) - 1);
                if (left + key <= right) {
                    search(count + 1, left + key, right);
                }
                search(count + 1, left, right + key);
                visited.put(key, visited.get(key) + 1);
            }
        }
    }
}
