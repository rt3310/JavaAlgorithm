package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q5430 {
    private static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, "[],");
            Deque<String> dq = new ArrayDeque<>();
            while (st.hasMoreTokens()) {
                dq.add(st.nextToken());
            }

            boolean reverse = false;
            boolean hasError = false;
            for (int j = 0; j < command.length(); j++) {
                if (command.charAt(j) == 'R') {
                    reverse = !reverse;
                    continue;
                }

                if (dq.isEmpty()) {
                    hasError = true;
                    break;
                }

                if (command.charAt(j) == 'D') {
                    if (reverse) {
                        dq.pollLast();
                    } else {
                        dq.pollFirst();
                    }
                }

            }

            if (hasError) {
                System.out.println("error");
                continue;
            }

            StringBuilder sb = new StringBuilder("[");
            if (reverse) {
                while (!dq.isEmpty()) {
                    sb.append(dq.pollLast()).append(",");
                }
            } else {
                while (!dq.isEmpty()) {
                    sb.append(dq.pollFirst()).append(",");
                }
            }

            if (sb.charAt(sb.length() - 1) == ',') {
                sb.setCharAt(sb.length() - 1, ']');
            } else {
                sb.append("]");
            }

            System.out.println(sb);
        }
    }
}
