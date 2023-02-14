package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WaterPool {

    private static int[] ticketCosts;
    private static int[] months;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
         br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            testCase(i);
        }
    }

    public static void testCase(int test) throws IOException {
        ticketCosts = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        months = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void search(int month) {

    }
}
