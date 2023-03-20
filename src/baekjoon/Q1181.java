package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Q1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strs.add(br.readLine());
        }

        List<String> result = strs.stream()
                .distinct()
                .sorted((s1, s2) -> {
                    if (s1.length() == s2.length()) {
                        return s1.compareTo(s2);
                    }
                    return s1.length() - s2.length();
                })
                .collect(Collectors.toList());

        for (String str : result) {
            sb.append(str).append("\n");
        }

        System.out.print(sb);
    }
}
