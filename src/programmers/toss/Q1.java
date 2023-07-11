package programmers.toss;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        System.out.println(q1.solution("1451232125", 2));
        System.out.println(q1.solution("313253123", 3));
        System.out.println(q1.solution("12412415", 4));
    }

    public int solution(String s, int N) {
        int length = s.length();

        if (length == 0 || length < N) {
            return -1;
        }

        Map<Character, Integer> counts = new HashMap<>();
        int start = 0;
        int end = N - 1;
        Queue<Integer> answerQ = new PriorityQueue<>(Comparator.comparingInt(v -> -v));

        for (int i = start; i <= end; i++) {
            char key = s.charAt(i);
            counts.put(key, counts.getOrDefault(key, 0) + 1);
        }

        while (true) {
            boolean valid = true;
            for (int i = 1; i <= N; i++) {
                if (counts.getOrDefault((char) (i + 48), 0) != 1) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                answerQ.offer(Integer.parseInt(s.substring(start, end + 1)));
            }

            if (end >= length - 1) {
                break;
            }

            char startKey = s.charAt(start);
            counts.put(startKey, counts.get(startKey) - 1);
            start++;

            end++;
            char endKey = s.charAt(end);
            counts.put(endKey, counts.getOrDefault(endKey, 0) + 1);
        }

        if (answerQ.isEmpty()) {
            return -1;
        }

        return answerQ.poll();
    }
}
