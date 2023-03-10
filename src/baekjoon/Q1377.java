package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q1377 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = new int[]{num, i};
        }

        Arrays.sort(arr, Comparator.comparingInt(v -> v[0]));

        int count = 1;
        int min = arr[n - 1][0];
        for (int i = n - 2; i >= 0; i--) {
            count = Math.max(count, arr[i][1] - i);
        }

        System.out.println(count + 1);
    }
}
// 1 10 8 11 9
// 1 8 10 9 11

// 10 1 5 3 2
// 1 5 3 2 10

// 10 1 5 2 3
// 1 10 5 2 3  1 5 10 2 3  1 5 2 10 3  1 5 2 3 10
// 1 2 5 3 10  1 2 3 5 10

// 10 9 8 7 6
// 9 10 8 7 6  9 8 10 7 6  9 8 7 10 6  9 8 7 6 10
// 8 9 7 6 10  8 7 9 6 10  8 7 6 9 10
// 7 8 6 9 10  7 6 8 9 10
// 6 7 8 9 10