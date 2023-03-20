package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[][] chess = new String[n][m];
        int[][] leftTopBlack = new int[n][m];
        int[][] leftTopWhite = new int[n][m];

        for (int i = 0; i < n; i++) {
            chess[i] = br.readLine().split("");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i + j) % 2 == 0) {
                    if (chess[i][j].equals("W")) {
                        leftTopBlack[i][j]++;
                        continue;
                    }
                    leftTopWhite[i][j]++;
                }
                if ((i + j) % 2 == 1) {
                    if (chess[i][j].equals("B")) {
                        leftTopBlack[i][j]++;
                        continue;
                    }
                    leftTopWhite[i][j]++;
                }
            }
        }

        int answer = 2500;
        for (int i = 0; i < n - 8 + 1; i++) {
            for (int j = 0; j < m - 8 + 1; j++) {
                int blackTotal = 0;
                int whiteTotal = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        blackTotal += leftTopBlack[k + i][l + j];
                        whiteTotal += leftTopWhite[k + i][l + j];
                    }
                }
                int min = Math.min(blackTotal, whiteTotal);
                answer = Math.min(answer, min);
            }
        }

        System.out.println(answer);
    }
}

// 00 01 02 03 04 05 06 07 08
// 10 11 12 13 14 15 16 17 18
// 20 21 22 23 24 25 26 27 28