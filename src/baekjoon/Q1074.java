package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1074 {

    private static int length;
    private static int row;
    private static int col;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nrc = br.readLine().split(" ");

        int n = Integer.parseInt(nrc[0]);
        row = Integer.parseInt(nrc[1]);
        col = Integer.parseInt(nrc[2]);

        length = 2 << (n-1);
        int count = length * length;

        recur(length, count, length, length);
    }

    public static void recur(int width, int count, int r, int c) {
        if (width == 1) {
            if (r - 1 == row && c - 1 == col) {
                System.out.println(count - 1);
            }
            return;
        }

        width /= 2;

        if (row < r - width && col < c - width) {
            recur(width, count - width * width * 3, r - width, c - width);
        } else if (row < r - width && col < c) {
            recur(width, count - width * width * 2, r - width, c);
        } else if (row < r && col < c - width) {
            recur(width, count - width * width, r, c - width);
        } else {
            recur(width, count, r, c);
        }
    }
}
