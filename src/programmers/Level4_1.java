package programmers;

import java.util.*;

public class Level4_1 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"1", "-", "3", "+", "5", "-", "8"}));
        System.out.println(solution(new String[]{"5", "-", "3", "+", "1", "+", "2", "-", "4"}));
    }

    public static int solution(String[] arr) {
        int answer = 0;
        int arrLen = arr.length;
        int[] numbers = new int[arrLen / 2 + 1];
        String[] operators = new String[arrLen / 2];

        int numberCount = 0;
        int operatorCount = 0;
        for (int i = 0; i < arrLen; i++) {
            if (i % 2 == 0) {
                operators[operatorCount] = arr[i];
                operatorCount++;
                continue;
            }
            numbers[numberCount] = Integer.parseInt(arr[i]);
            numberCount++;
        }

        Deque<Integer> dq = new ArrayDeque<>();

        int total = numbers[0];
        for (int i = 1; i < arrLen / 2 + 1; i++) {
            if (operators[i - 1].equals("-")) {

            }
        }
        return answer;
    }
}
