package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        int cur = 1;
        boolean status = true;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            while (number >= cur) {
                stack.push(cur++);
                answer.append("+");
            }

            while (true) {
                if (stack.isEmpty()) {
                    status = false;
                    break;
                }

                int popNum = stack.pop();
                answer.append("-");

                if (popNum < number) {
                    status = false;
                }

                if (popNum <= number) {
                    break;
                }
            }
        }

        if (status) {
            for (char s : answer.toString().toCharArray()) {
                System.out.println(s);
            }
        } else {
            System.out.println("NO");
        }
    }
}
