package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17406 {

    private static int n;
    private static int m;
    private static String[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmk = br.readLine().split(" ");
        n = Integer.parseInt(nmk[0]);
        m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);
        arr = new String[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < k; i++) {
            String[] rcs = br.readLine().split(" ");
            int r = Integer.parseInt(rcs[0]);
            int c = Integer.parseInt(rcs[1]);
            int s = Integer.parseInt(rcs[2]);
            spin(r, c, s);
        }

        int min = Integer.MAX_VALUE;
        for (String[] arrR: arr) {
            int total = 0;
            for (String arrD: arrR) {
                total += Integer.parseInt(arrD);
            }
            min = Math.min(min, total);
        }

        System.out.println(min);
    }

    public static void spin(int r, int c, int s) {
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        visited = new boolean[n][m];

        int count = 0;
        while (true) {
            int row = r - s - 1 + count;
            int col = c - s - 1 + count;
            int curDirect = 0;
            String temp = arr[row][col];
            if (visited[row][col]) {
                break;
            }
            visited[row][col] = true;
            int curRow = row;
            int curCol = col;
            while (true) {
                int nextRow = curRow + directions[curDirect][0];
                int nextCol = curCol + directions[curDirect][1];

                if (nextRow == row && nextCol == col) {
                    String nextTemp = arr[nextRow][nextCol];
                    arr[nextRow][nextCol] = temp;
                    temp = nextTemp;
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
                String nextTemp = arr[nextRow][nextCol];
                arr[nextRow][nextCol] = temp;
                temp = nextTemp;
                curRow = nextRow;
                curCol = nextCol;
            }
            count++;
        }
    }
}
