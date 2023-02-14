package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            triangle.add(Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j) + triangle.get(i).get(j));
                    continue;
                }

                if (j == i) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                    continue;
                }

                int prev = Math.max(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1));
                triangle.get(i).set(j, prev + triangle.get(i).get(j));
            }
        }
        int max = 0;
        for (int num :
                triangle.get(triangle.size() - 1)) {
            max = Math.max(max, num);
        }

        System.out.println(max);
    }
}
