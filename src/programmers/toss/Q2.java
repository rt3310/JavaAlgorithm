package programmers.toss;

import java.util.*;

public class Q2 {
    
    private List<List<Integer>> graph;
    private int point;

    public static void main(String[] args) {
        Q2 q2 = new Q2();

        System.out.println(q2.solution(new int[][]{{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}}, 2, 3));
    }

    public int solution(int[][] relationships, int target, int limit) {
        point = 0;
        graph = new ArrayList<>();
        
        for (int i = 0; i <= 100; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] relationship : relationships) {
            int one = relationship[0];
            int two = relationship[1];

            graph.get(one).add(two);
            graph.get(two).add(one);
        }

        search(target, limit);
        return point;
    }
    
    public void search(int start, int limit) {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[101];

        dq.offerLast(new int[]{start, 0});
        visited[start] = true;

        int count = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();

            if (cur[1] == 1) {
                point += 5;
            } else if (cur[1] > 1 && cur[1] <= limit) {
                point += 10;
                count++;
            }

            for (int next : graph.get(cur[0])) {
                if (visited[next]) {
                    continue;
                }

                if (cur[1] + 1 > limit) {
                    continue;
                }

                visited[next] = true;
                dq.offerLast(new int[]{next, cur[1] + 1});
            }
        }

        point += count;
    }
}
