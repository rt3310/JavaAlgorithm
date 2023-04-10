package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11729 {

    private static int n;
    private static int moveCount;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        moveCount = 0;

        hanoi(1, 2, 3, 0);

        System.out.println(moveCount);
        System.out.print(sb);
    }

    public static void hanoi(int start, int mid, int target, int count) {
        if (count == n) {
            return;
        }

        hanoi(start, target, mid, count + 1);
        moveCount++;
        sb.append(start).append(" ").append(target).append("\n");
        hanoi(mid, start, target, count + 1);
    }
}
