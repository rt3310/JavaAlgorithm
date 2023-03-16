package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q9019 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static Queue<String> pq;
    private static int dest;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            testcase();
        }

        System.out.println(sb);
    }

    private static void testcase() throws IOException {
        String[] ab = br.readLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        dest = Integer.parseInt(ab[1]);
        pq = new PriorityQueue<>(Comparator.comparingInt(String::length));

        search(a, Math.abs(a - dest), new StringBuilder());
        sb.append(pq.poll()).append("\n");
    }

    public static void search(int number, int depth, StringBuilder operates) {
        String numberToString = String.valueOf(number);
        int length = numberToString.length();

        if (number >= dest) {
            pq.offer(operates + "S".repeat(number - dest));
        }

        if (depth == 0) {
            return;
        }

        if (length > 1) {
            int pow = (int) Math.pow(10, (length - 1));
            int lastDigit = number % 10;
            int numberExcludeLastDigit = number / 10;
            int popRight = numberExcludeLastDigit + (lastDigit * pow);
            operates.append("R");
            search(popRight, depth - 1, operates);
            operates.deleteCharAt(operates.length() - 1);

            int firstDigit = number / pow;
            int numberExcludeFirstDigit = number % pow;
            int popLeft = numberExcludeFirstDigit * 10 + firstDigit;
            operates.append("L");
            search(popLeft, depth - 1, operates);
            operates.deleteCharAt(operates.length() - 1);
        }

        operates.append("D");
        search((number * 2) % 10000, depth - 1, operates);
        operates.deleteCharAt(operates.length() - 1);
    }
}
