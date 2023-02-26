package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        System.out.println(list);
        int left = 0;
        int right = 0;

        int count = 0;
        while (left < n) {
            int sum;
            if (left == right) {
                sum = left;
            } else {
                sum = list.get(left) + list.get(right);
            }

            if (sum == n) {
                count++;
                left++;
                continue;
            }

            if (sum < n) {
                left++;
                continue;
            }

            right--;
            continue;
        }

        System.out.println(count);
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        if (number != 2 && number % 2 == 0) {
            return false;
        }

        for (int i = 3; i < Math.sqrt(number) + 1; i+=2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
