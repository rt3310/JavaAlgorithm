package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q16236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] map = new String[n][n];
        int[] shark = new int[2];
        List<List<Integer>> fish = new ArrayList<>(7);

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < 7; i++) {
            fish.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("0")) {
                    continue;
                }

                if (map[i][j].equals("9")) {
                    shark = new int[]{i, j};
                    continue;
                }
                fish.add(Integer.parseInt(map[i][j]), List.of(i, j));
            }
        }

        System.out.println(fish.get(1).size());
    }
}
