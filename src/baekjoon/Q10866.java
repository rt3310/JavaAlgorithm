package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push_front")) {
                dq.offerFirst(Integer.parseInt(st.nextToken()));
                continue;
            }

            if (command.equals("push_back")) {
                dq.offerLast(Integer.parseInt(st.nextToken()));
                continue;
            }

            if (command.equals("pop_front")) {
                if (dq.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(dq.pollFirst()).append("\n");
                continue;
            }

            if (command.equals("pop_back")) {
                if (dq.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(dq.pollLast()).append("\n");
                continue;
            }

            if (command.equals("size")) {
                sb.append(dq.size()).append("\n");
                continue;
            }

            if (command.equals("empty")) {
                if (dq.isEmpty()) {
                    sb.append("1").append("\n");
                    continue;
                }
                sb.append("0").append("\n");
                continue;
            }

            if (command.equals("front")) {
                if (dq.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(dq.peekFirst()).append("\n");
                continue;
            }

            if (command.equals("back")) {
                if (dq.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(dq.peekLast()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
