package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1074 {

    private static int length;
    private static int n;
    private static int row;
    private static int col;
    private static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nrc = br.readLine().split(" ");

        n = Integer.parseInt(nrc[0]);
        row = Integer.parseInt(nrc[1]);
        col = Integer.parseInt(nrc[2]);
        count = 0;

        length = 2 << (n-1);

        search(0, 0, length, 0);
    }

    public static void search(int r, int c, int size, int count) {
        if (r == row && c == col) {
            System.out.println(count);
            return;
        }

        int mid = size / 2;
        if (row < r + mid && col < c + mid) {
            search(r, c, mid, count);
        }
        if (row < r + mid && col >= c + mid) {
            search(r, c + mid, mid, count + (mid * mid));
        }
        if (row >= r + mid && col < c + mid) {
            search(r + mid, c, mid, count + (2 * mid * mid));
        }
        if (row >= r + mid && col >= c + mid) {
            search(r + mid, c + mid, mid, count + (3 * mid * mid));
        }
    }
}
