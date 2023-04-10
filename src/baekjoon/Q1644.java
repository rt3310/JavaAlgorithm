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

        if (list.isEmpty()) {
            System.out.println(0);
            return;
        }

        int left = 0;
        int right = 0;
        int total = list.get(0);
        int count = 0;

        int size = list.size();
        while (left <= right) {
            if (total > n) {
                total -= list.get(left);
                left++;
                continue;
            }

            if (total == n) {
                count++;
            }
            right++;
            if (right >= size) {
                break;
            }
            total += list.get(right);
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
