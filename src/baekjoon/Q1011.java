package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1011 {

    private static int x;
    private static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            search(x, 0);
        }
    }

    public static void search(int cur, int count) {
        if (cur >= y) {
            return;
        }

        if (y - cur == 1) {
            System.out.println(count);
            return;
        }

        int next1 = cur + 1;
        int next3 = cur - 1;

        if (next3 > 0) {
            search(cur + next3, count + 1);
        }

        if (cur < (x + y) / 2) {
            search(cur + next1, count + 1);
            if (cur > 0) {
                search(cur + cur, count + 1);
            }
        }
    }
}
