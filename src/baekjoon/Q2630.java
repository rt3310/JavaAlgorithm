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

        search(0, n - 1, 0, n - 1, n);

        System.out.println(color.get(WHITE));
        System.out.println(color.get(BLUE));
    }

    public static void search(int sx, int ex, int sy, int ey, int height) {
        if (sx >= ex && sy >= ey) {
            color.put(map[sx][sy], color.get(map[sx][sy]) + 1);
            return;
        }

        String standard = map[sx][sy];

        int xmid = (sx + ex) / 2;
        int ymid = (sy + ey) / 2;

        if (isAllSame(sx, ex, sy, ey, standard)) {
            color.put(standard, color.get(standard) + 1);
            return;
        }

        search(sx, xmid, sy, ymid, height / 2);
        search(xmid+1, ex, sy, ymid, height / 2);
        search(sx, xmid, ymid+1, ey, height / 2);
        search(xmid+1, ex, ymid+1, ey, height / 2);
    }

    private static boolean isAllSame(int sx, int ex, int sy, int ey, String standard) {
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                if (!map[i][j].equals(standard)) {
                    return false;
                }
            }
        }
        return true;
    }
}
