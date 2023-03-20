package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        for (int i = 1; i <= n; i++) {
            dq.offerLast(i);
        }

        int count = 0;
        while (!dq.isEmpty()) {
            int number = dq.pollFirst();
            count++;
            if (count % k == 0) {
                answer.add(number);
                continue;
            }
            dq.offerLast(number);
        }

        sb.append("<");
        sb.append(answer.get(0));
        for (int i = 1; i < answer.size(); i++) {
            sb.append(", ").append(answer.get(i));
        }
        sb.append(">");

        System.out.println(sb);
    }
}
