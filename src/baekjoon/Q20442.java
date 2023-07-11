package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q20442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int length = s.length();

        int count = 0;
        List<Integer> left = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'K') {
                count++;
                continue;
            }
            left.add(count);
        }

        count = 0;
        List<Integer> right = new ArrayList<>();
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == 'K') {
                count++;
                continue;
            }
            right.add(count);
        }

        int l = 0;
        int r = right.size() - 1;
        int max = 0;
        while (l <= r) {
            int leftCount = left.get(l);
            int rightCount = right.get(right.size() - 1 - r);
            max = Math.max(max, (r - l + 1) + (Math.min(leftCount, rightCount) * 2));

            if (leftCount < rightCount) {
                l++;
                continue;
            }
            r--;
        }

        System.out.println(max);
    }
}
