package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2383 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static List<int[]> mans;
    private static List<int[]> stairs;
    private static Queue<int[]> pq;
    private static int manSize;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");
            testCase();
        }

        System.out.print(sb);
    }

    private static void testCase() throws IOException {
        mans = new ArrayList<>();
        stairs = new ArrayList<>();
        pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) {
                    mans.add(new int[]{i, j});
                    continue;
                }
                if (v > 1) {
                    stairs.add(new int[]{i, j});
                }
            }
        }
        manSize = mans.size();
        visited = new int[manSize];

        visited[0] = 0;
        search(0);
        visited[0] = 1;
        search(0);
    }

    public static void search(int count) {
        if (count == manSize - 1) {
            System.out.println(Arrays.toString(visited));
            return;
        }

        for (int i = 0; i < 2; i++) {
            visited[count + 1] = i;
            search(count + 1);
        }
    }

    public static void check() {
        for (int i = 0; i < manSize; i++) {
            int[] stair = stairs.get(visited[i]);
            int[] man = mans.get(i);
            pq.offer(new int[]{Math.abs(stair[0] - man[0]) + Math.abs(stair[1] - man[1]), i});
        }
    }
}
