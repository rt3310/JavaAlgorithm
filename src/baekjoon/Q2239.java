//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Q2239 {
//
//    private static boolean[][] rowCheck;
//    private static boolean[][] colCheck;
//    private static boolean[][] boxCheck;
//    private static int[][] sudoku;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        rowCheck = new boolean[9][10];
//        colCheck = new boolean[9][10];
//        boxCheck = new boolean[9][10];
//
//        sudoku = new int[9][9];
//
//        for (int i = 0; i < 9; i++) {
//            String[] row = br.readLine().split("");
//            for (int j = 0; j < 9; j++) {
//                int value = Integer.parseInt(row[j]);
//                sudoku[i][j] = value;
//                if (value != 0) {
//                    rowCheck[i][value] = true;
//                    colCheck[j][value] = true;
//                    setBox(i, j, value);
//                }
//            }
//        }
//
//        search(0);
//    }
//    public static void search(int row) {
//        boolean isFull = true;
//        for (int i = 0; i < 9; i++) {
//            if (sudoku[row][i] != 0) {
//                continue;
//            }
//
//            isFull = false;
//            for (int j = 1; j < 10; j++) {
//                if (rowCheck[row][j]) {
//                    continue;
//                }
//
//                if (colCheck[i][j]) {
//                    continue;
//                }
//
//                if (!setBox(row, i, j)) {
//                   continue;
//                }
//
//                sudoku[row][i] = j;
//                rowCheck[row][j] = true;
//                colCheck[i][j] = true;
//                setBox(row, i, j);
//                search(row);
//                sudoku[row][i] = 0;
//                rowCheck[row][j] = false;
//                colCheck[i][j] = false;
//                unsetBox(row, i, j);
//            }
//        }
//        if (row == 8) {
//            if (checkNotZero()) {
//                for (int[] r : sudoku) {
//                    for (int v : r) {
//                        System.out.print(v + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//            }
//            return;
//        }
//
//        if (isFull) {
//            search(row + 1);
//        }
//    }
//
//    public static boolean checkNotZero() {
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (sudoku[i][j] == 0) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//}
