package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16926 {

    private static int n;
    private static int m;
    private static int r;
    private static String[][] arr;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmr = br.readLine().split(" ");
        n = Integer.parseInt(nmr[0]);
        m = Integer.parseInt(nmr[1]);
        r = Integer.parseInt(nmr[2]);

        arr = new String[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < r; i++) {
            spin();
        }

        StringBuilder sb = new StringBuilder();
        for (String[] arrRow : arr) {
            for (String dot : arrRow) {
                sb.append(dot).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void spin() {
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        visited = new boolean[n][m];

        int count = 0;
        while (true) {
            int row = count;
            int col = count;
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

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
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
