package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            int length = str.length();
            boolean isFail = false;
            for (int j = 0; j < length; j++) {
                char c = str.charAt(j);
                if (c == '(') {
                    stack.push(c);
                    continue;
                }

                if (stack.isEmpty() || stack.pop() != '(') {
                    isFail =  true;
                    sb.append("NO\n");
                    break;
                }
            }

            if (isFail) {
                continue;
            }

            if (!stack.isEmpty()) {
                sb.append("NO\n");
                continue;
            }

            sb.append("YES\n");
        }

        System.out.print(sb);
    }
}
