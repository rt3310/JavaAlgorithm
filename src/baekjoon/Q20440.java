package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Q20440 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> pos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int t1 = Integer.parseInt(input[0]);
            int t2 = Integer.parseInt(input[1]);
            pos.put(t1, pos.getOrDefault(t1, 0) + 1);
            pos.put(t2, pos.getOrDefault(t2, 0) - 1);
        }

        List<int[]> sortedPos = pos.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(e -> new int[]{e.getKey(), e.getValue()})
                .collect(Collectors.toList());

        int length = sortedPos.size();
        for (int i = 0; i < length - 1; i++) {
            sortedPos.get(i + 1)[1] += sortedPos.get(i)[1];
        }

        int start = 0;
        int cur = 0;
        int end = 0;

        int maxStart = 0;
        int max = 0;
        int maxEnd = 0;

        for (int i = 0; i < length; i++) {
            if (sortedPos.get(i)[1] > cur) {
                start = sortedPos.get(i)[0];
                cur = sortedPos.get(i)[1];
                if (cur > max) {
                    maxStart = start;
                    max = cur;
                }
                continue;
            }

            if (sortedPos.get(i)[1] < cur) {
                end = sortedPos.get(i)[0];
                if (cur == max && maxStart >= maxEnd) {
                    maxEnd = end;
                }
                cur = sortedPos.get(i)[1];
            }
        }

        System.out.println(max);
        System.out.println(maxStart + " " + maxEnd);
    }
}
