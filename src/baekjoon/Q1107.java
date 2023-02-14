package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Q1107 {
    private static boolean[] breakedButtons;
    private static String channel;
    private static int minCount;
    private static List<List<Integer>> numList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        channel = br.readLine();
        int m = Integer.parseInt(br.readLine());

        breakedButtons = new boolean[10];

        if (m != 0) {
            for (String button : br.readLine().split(" ")) {
                breakedButtons[Integer.parseInt(button)] = true;
            }
        }

        minCount = Math.abs(Integer.parseInt(channel) - 100);
        if (minCount == 0 || isAllBreak()) {
            System.out.println(minCount);
            return;
        }

        numList = new ArrayList<>();
        for (int i = 0; i < channel.length(); i++) {
            int number = channel.charAt(i) - '0';
            List<Integer> list = new ArrayList<>();
            int count = 0;
            while (count < 10) {
                if (!breakedButtons[(number + count) % 10]) {
                    list.add((number + count) % 10);
                }

                if (!breakedButtons[Math.floorMod(number - count, 10)]) {
                    list.add(Math.floorMod(number - count, 10));
                }
                count++;
            }
            numList.add(list);
        }

        for (int i = 0; i < numList.get(0).size(); i++) {
            search(1, String.valueOf(numList.get(0).get(i)));
        }

        System.out.println(channel.length() + minCount);
    }

    public static void search(int count, String number) {
        if (count == channel.length()) {
            minCount = Math.min(minCount, Math.abs(Integer.parseInt(channel) - Integer.parseInt(number)));
            return;
        }

        for (int i = 0; i < numList.get(count).size(); i++) {
            search(count + 1, number + numList.get(count).get(i));
        }
    }

    public static boolean isAllBreak() {
        for (int i = 0; i < 10; i++) {
            if (!breakedButtons[i]) {
                return false;
            }
        }
        return true;
    }
}
