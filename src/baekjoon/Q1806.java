package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ns = br.readLine().split(" ");
        int n = Integer.parseInt(ns[0]);
        int s = Integer.parseInt(ns[1]);
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int total = arr[left];
        int minLength = Integer.MAX_VALUE;
        while (left <= right) {
            if (total >= s) {
                minLength = Math.min(minLength, right - left + 1);
                total -= arr[left];
                left++;
                continue;
            }

            right++;
            if (right >= n) {
                break;
            }
            total += arr[right];
        }

        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
