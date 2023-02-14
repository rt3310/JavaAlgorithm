package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WaterPool {

    private static BufferedReader br;
    private static int[] prices;
    private static int[] months;
    private static int minPrice;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            minPrice = Integer.MAX_VALUE;
            testCase(i);
        }
    }

    public static void testCase(int caseCount) throws IOException {
        prices = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        months = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        search(months[0] * prices[0],   2);
        search(prices[1], 2);
        search(prices[2], 4);
        search(prices[3], 13);

        System.out.println("#" + caseCount + " " + minPrice);
    }

    public static void search(int curPrice, int count) {
        if (count > 12) {
            minPrice = Math.min(minPrice, curPrice);
            return;
        }

        int dayPrice = curPrice + (months[count - 1] * prices[0]);
        int monthPrice = curPrice + prices[1];
        int threeMonthPrice = curPrice + prices[2];
        int yearPrice = curPrice + prices[3];

        search(dayPrice, count + 1);
        search(monthPrice, count + 1);
        search(threeMonthPrice, count + 3);
        search(yearPrice, count + 12);
    }
}