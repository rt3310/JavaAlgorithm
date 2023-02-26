package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1138_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        String[] leftCounts = br.readLine().split(" ");

        for (int i = n - 1; i >= 0; i--) {
            int leftCount = Integer.parseInt(leftCounts[i]);

            if (leftCount == 0) {
                numbers.add(0, i + 1);
                continue;
            }

            int count = 0;
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(j) > i + 1) {
                    count++;
                }

                if (count == leftCount) {
                    numbers.add(count, i + 1);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(numbers.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
