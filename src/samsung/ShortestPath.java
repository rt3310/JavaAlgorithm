package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ShortestPath {

    private static BufferedReader br;
    private static int[] company;
    private static int[] home;
    private static int minDistance;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            testCase(i);
        }
    }

    public static void testCase(int count) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] customers = new int[n][2];
        boolean[] visited = new boolean[n];
        minDistance = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        company = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        home = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        for (int i = 0; i < n; i++) {
            customers[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            search(customers, visited, calcDistance(company, customers[i]), n, i);
            visited[i] = false;
        }

        System.out.println("#" + count + " " + minDistance);
    }

    public static void search(int[][] customers, boolean[] visited, int curDistance, int count, int cur) {
        if (count == 1) {
            minDistance = Math.min(minDistance, curDistance + calcDistance(customers[cur], home));
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                search(customers, visited, curDistance + calcDistance(customers[cur], customers[i]), count - 1, i);
                visited[i] = false;
            }
        }
    }

    public static int calcDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
