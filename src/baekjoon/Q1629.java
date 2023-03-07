package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);
        List<Integer> remains = new ArrayList<>();

        long total = 1;
        int idx = -1;
        for (int i = 1; i < n; i++) {
            total *= n;

            if (idx == -1) {
                remains.add((int) (total % m));
                idx++;
                continue;
            }

            if (total % m == remains.get(idx)) {
                if (idx == remains.size() - 1) {
                    break;
                }
                idx++;
                continue;
            }
            remains.add((int) (total % m));
            idx = 0;
        }

        System.out.println(remains.get((r - 1) % remains.size()));
    }
}
