package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2615 {
    private final static int LENGTH = 19;
    private final static String BLANK = "0";
    private final static int FIVE_END = 5;
    private static String[][] board;

    private static String result = "0";
    private static int resultRow;
    private static int resultCol;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new String[LENGTH][LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            board[i] = br.readLine().split(" ");
        }

        int[][] directions = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};

        boolean isValid = false;
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                if (board[i][j].equals(BLANK)) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int count = 1;
                    int curRow = i;
                    int curCol = j;
                    while (true) {
                        curRow += directions[k][0];
                        curCol += directions[k][1];

                        System.out.println("curRow = " + curRow + ", curCol = " + curCol);
                        if (isInvalidPosition(curRow, curCol)) {
                            System.out.print("curRow = " + curRow + ", curCol = " + curCol);
                            System.out.println(" invalid");
                            break;
                        }

                        if (!board[curRow][curCol].equals(board[i][j])) {
                            System.out.print("curRow = " + curRow + ", curCol = " + curCol);
                            System.out.println(" not same");
                            break;
                        }
                        count++;
                    }

                    if (count == FIVE_END && isNotExistBack(i, j, -directions[k][0], -directions[k][1], board[i][j])) {
                        resultRow = i + 1;
                        resultCol = j + 1;
                        result = board[i][j];
                        isValid = true;
                        break;
                    }
                }
                if (isValid) {
                    break;
                }
            }
            if (isValid) {
                break;
            }
        }
        System.out.println(result);
        if (!result.equals("0")) {
            System.out.println(resultRow + " " + resultCol);
        }
    }

    private static boolean isInvalidPosition(int row, int col) {
        if (LENGTH - row < FIVE_END && LENGTH - col < FIVE_END) {
            return true;
        }

        if (row < 0 || row >= LENGTH || col < 0 || col >= LENGTH) {
            return true;
        }

        return false;
    }

    private static boolean isNotExistBack(int startRow, int startCol, int backMoveRow, int backMoveCol, String color) {
        int backRow = startRow + backMoveRow;
        int backCol = startCol + backMoveCol;

        if (backRow < 0 || backRow >= LENGTH || backCol < 0 || backCol >= LENGTH) {
            return true;
        }

        return !board[backRow][backCol].equals(color);
    }
}
