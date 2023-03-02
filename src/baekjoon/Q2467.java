package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int min = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = n - 1;
        while (left < right) {
            int leftSol = arr[left];
            int rightSol = arr[right];

            if (leftSol + rightSol == 0) {
                minLeft = left;
                minRight = right;
                break;
            }

            if (Math.abs(leftSol + rightSol) < min) {
                min = Math.abs(leftSol + rightSol);
                minLeft = left;
                minRight = right;
            }

            if (leftSol + rightSol > 0) {
                right--;
                continue;
            }
            left++;
        }

        System.out.println(arr[minLeft] + " " + arr[minRight]);
    }
}
