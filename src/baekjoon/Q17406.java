package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17406 {

    private static int n;
    private static int m;
    private static int k;
    private static String[][] arr;
    private static int[][] rcsArr;
    private static boolean[] rcsVisited;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmk = br.readLine().split(" ");
        n = Integer.parseInt(nmk[0]);
        m = Integer.parseInt(nmk[1]);
        k = Integer.parseInt(nmk[2]);
        arr = new String[n][m];
        rcsArr = new int[k][3];
        rcsVisited = new boolean[k];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < k; i++) {
            String[] rcs = br.readLine().split(" ");
            int r = Integer.parseInt(rcs[0]);
            int c = Integer.parseInt(rcs[1]);
            int s = Integer.parseInt(rcs[2]);
            rcsArr[i] = new int[]{r, c, s};
        }

        for (int i = 0; i < k; i++) {
            rcsVisited[i] = true;
            search(1, spin(arr, rcsArr[i][0], rcsArr[i][1], rcsArr[i][2]));
            rcsVisited[i] = false;
        }

        System.out.println(min);
    }

    public static void search(int count, String[][] arr) {
        if (count == k) {
            min = Math.min(min, getMin(arr));
            return;
        }

        for (int i = 0; i < k; i++) {
            if (rcsVisited[i]) {
                continue;
            }

            rcsVisited[i] = true;
            search(count + 1, spin(arr, rcsArr[i][0], rcsArr[i][1], rcsArr[i][2]));
            rcsVisited[i] = false;
        }
    }

    public static String[][] spin(String[][] arr, int r, int c, int s) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[n][m];
        String[][] copy = new String[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, copy[i], 0, m);
        }

        int count = 0;
        while (true) {
            int row = r - s - 1 + count;
            int col = c - s - 1 + count;
            int curDirect = 0;
            String temp = copy[row][col];
            if (visited[row][col]) {
                break;
            }
            visited[row][col] = true;
            int curRow = row;
            int curCol = col;
            int seekCount = 0;
            while (true) {
                seekCount++;

                int nextRow = curRow + directions[curDirect][0];
                int nextCol = curCol + directions[curDirect][1];

                if (nextRow == row && nextCol == col) {
                    String nextTemp = copy[nextRow][nextCol];
                    copy[nextRow][nextCol] = temp;
                    temp = nextTemp;
                    break;
                }

                if (seekCount == 4) {
                    break;
                }

                if (nextRow < r-s-1 || nextRow > r+s-1 || nextCol < c-s-1 || nextCol > c+s-1) {
                    curDirect = (curDirect + 1) % 4;
                    continue;
                }

                if (visited[nextRow][nextCol]) {
                    curDirect = (curDirect + 1) % 4;
                    continue;
                }

                visited[nextRow][nextCol] = true;
                String nextTemp = copy[nextRow][nextCol];
                copy[nextRow][nextCol] = temp;
                temp = nextTemp;
                curRow = nextRow;
                curCol = nextCol;
                seekCount = 0;
            }
            count++;
        }
        return copy;
    }

    private static int getMin(String[][] arr) {
        int min = Integer.MAX_VALUE;
        for (String[] arrR: arr) {
            int total = 0;
            for (String arrD: arrR) {
                total += Integer.parseInt(arrD);
            }
            min = Math.min(min, total);
        }
        return min;
    }
}
