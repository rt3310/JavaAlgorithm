package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1107 {
    private static boolean[] brokeButtons;
    private static String channel;
    private static int n;
    private static int minCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        channel = br.readLine();
        int m = Integer.parseInt(br.readLine());
        brokeButtons = new boolean[10];

        String[] buttons = br.readLine().split(" ");
        if (m != 0) {
            for (String button : buttons) {
                brokeButtons[Integer.parseInt(button)] = true;
            }
        }

        minCount = Math.abs(Integer.parseInt(channel) - 100);
        if (minCount == 0) {
            System.out.println(minCount);
            return;
        }

        for (int i = 0; i < n; i++) {
        }
    }

    public static void search(int count, int number) {
        if (count == n) {
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (brokeButtons[i]) {
                continue;
            }

        }
    }
}
