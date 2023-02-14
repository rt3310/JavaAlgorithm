package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1244 {

    private static int n;
    private static String[] switches;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        switches = br.readLine().split(" ");

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            change(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        for (int i = 0; i < n; i++) {
            if (i != 0 && i % 20 == 0) {
                System.out.println();
            }

            System.out.print(switches[i] + " ");
        }
    }

    public static void change(int sex, int number) {
        if (sex == 1) {
            manChange(number);
            return;
        }
        womanChange(number);
    }

    public static void manChange(int number) {
        for (int i = 1; i <= n; i++) {
            if (i % number == 0) {
                switches[i - 1] = String.valueOf(Math.floorMod(Integer.parseInt(switches[i - 1]) - 1, 2));
            }
        }
    }

    public static void womanChange(int number) {
        int count = 1;

        switches[number - 1] = String.valueOf(Math.floorMod(Integer.parseInt(switches[number - 1]) - 1, 2));
        while ((number - count  - 1 >= 0) && (number + count - 1 < n)) {
            if (!switches[number - count - 1].equals(switches[number + count - 1])) {
                return;
            }
            switches[number - count - 1] = String.valueOf(Math.floorMod(Integer.parseInt(switches[number - count - 1]) - 1, 2));
            switches[number + count - 1] = String.valueOf(Math.floorMod(Integer.parseInt(switches[number + count - 1]) - 1, 2));
            count++;
        }
    }
}
