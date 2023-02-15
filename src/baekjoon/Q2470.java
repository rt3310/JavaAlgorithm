package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        while (st.hasMoreTokens()) {
            numbers[count++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int minAbs = Integer.MAX_VALUE;
        int minLeft = 0, minRight = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            int absSum = Math.abs(sum);
            if (absSum < minAbs) {
                minAbs = absSum;
                minLeft = left;
                minRight = right;
            }

            if (sum == 0) {
                break;
            }

            if (sum > 0) {
                right--;
            }

            if (sum < 0) {
                left++;
            }
        }

        System.out.println(numbers[minLeft] + " " + numbers[minRight]);
    }
}

// -10 -5 -3 -2 1 3 5 7 8
