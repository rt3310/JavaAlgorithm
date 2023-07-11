package programmers.toss;

import java.util.*;
import java.util.stream.Collectors;

public class Q4 {
    public static void main(String[] args) {
        Q4 q4 = new Q4();
        System.out.println(Arrays.toString(q4.solution(3, new String[]{"1", "2", "B", "B", "3"})));
        System.out.println(Arrays.toString(q4.solution(3, new String[]{"B", "B", "B", "B", "B"})));
        System.out.println(Arrays.toString(q4.solution(2, new String[]{"1", "2", "3", "4", "B", "F", "B", "F"})));
    }

    public String[] solution(int maxSize, String[] actions) {
        Map<String, Integer> visited = new HashMap<>();
        Map<Integer, String> inverseVisitedIndex = new HashMap<>();
        Deque<String> prevList = new ArrayDeque<>();
        Deque<String> nextList = new ArrayDeque<>();

        int visitCount = 0;
        String currentCategory = "";
        for (String action : actions) {
            if (action.equals("B")) {
                if (prevList.size() == 0) {
                    continue;
                }
                String prev = prevList.pollLast();
                if (visited.get(prev) != null) {
                    inverseVisitedIndex.remove(visited.get(prev));
                }
                visited.put(prev, visitCount);
                inverseVisitedIndex.put(visitCount, prev);
                visitCount++;
                nextList.offerFirst(currentCategory);
                continue;
            }

            if (action.equals("F")) {
                if (nextList.size() == 0) {
                    continue;
                }
                String next = nextList.pollFirst();
                if (visited.get(next) != null) {
                    inverseVisitedIndex.remove(visited.get(next));
                }
                visited.put(next, visitCount);
                inverseVisitedIndex.put(visitCount, next);
                visitCount++;
                prevList.offerLast(currentCategory);
                continue;
            }

            if (visited.get(action) != null) {
                inverseVisitedIndex.remove(visited.get(action));
            }
            visited.put(action, visitCount);
            inverseVisitedIndex.put(visitCount, action);
            visitCount++;
            if (!currentCategory.equals("")) {
                prevList.offerLast(currentCategory);
            }
            nextList.clear();
            currentCategory = action;
        }

        int size = Math.min(maxSize, visited.size());
        int index = visitCount - 1;
        int count = 0;
        String[] answer = new String[size];
        while (count < size) {
            String s = inverseVisitedIndex.get(index--);
            if (s == null) {
                continue;
            }
            answer[count++] = s;
        }
        return answer;
    }


}
