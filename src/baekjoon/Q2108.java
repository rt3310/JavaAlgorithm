package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int total = 0;
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers[i] = num;
            total += num;
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(numbers);
        long average = Math.round((double) total / n);
        int median = numbers[n / 2];
        List<int[]> countList = counts.entrySet().stream()
                .map(entry -> new int[]{entry.getKey(), entry.getValue()})
                .sorted((v1, v2) -> {
                    if (v1[1] == v2[1]) {
                        return v1[0] - v2[0];
                    }
                    return v2[1] - v1[1];
                })
                .collect(Collectors.toList());
        int mode = countList.get(0)[0];
        if (n > 1 && countList.get(1)[1] == countList.get(0)[1]) {
            mode = countList.get(1)[0];
        }

        int range = numbers[n - 1] - numbers[0];
        sb.append(average).append("\n");
        sb.append(median).append("\n");
        sb.append(mode).append("\n");
        sb.append(range);

        System.out.println(sb);
    }
}
