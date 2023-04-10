package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
            search(0, stack);
            stack.pop();
        }
    }

    public static void search(int count, Stack<Integer> numbers) {
        if (count == 4) {
            System.out.println(numbers);
            return;
        }

        for (int i = 0; i < 4; i++) {
            numbers.push(i);
            search(count + 1, numbers);
            numbers.pop();
        }
    }
}