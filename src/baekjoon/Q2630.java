package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q2630 {
    private final static String WHITE = "0";
    private final static String BLUE = "1";

    private static int n;
    private static String[][] map;
    private static Map<String, Integer> color;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        color = new HashMap<>();
        color.put(WHITE, 0);
        color.put(BLUE, 0);

        n = Integer.parseInt(br.readLine());
        map = new String[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
        }

        search(0, 0, n);

        System.out.println(color.get(WHITE));
        System.out.println(color.get(BLUE));
    }
    
    public static void search(int r, int c, int size) {
        if (size == 1) {
            color.put(map[r][c], color.get(map[r][c]) + 1);
            return;
        }

        if (isAllSame(r, c, size, map[r][c])) {
            color.put(map[r][c], color.get(map[r][c]) + 1);
            return;
        }

        int mid = size / 2;
        search(r, c, mid);
        search(r, c + mid, mid);
        search(r + mid, c, mid);
        search(r + mid, c + mid, mid);
    }

    private static boolean isAllSame(int r, int c, int size, String standard) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (!map[i][j].equals(standard)) {
                    return false;
                }
            }
        }
        return true;
    }
}
