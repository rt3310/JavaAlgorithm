package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1759 {

    private static int l;
    private static int c;
    private static String[] alphas;
    private static List<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] lc = br.readLine().split(" ");
        l = Integer.parseInt(lc[0]);
        c = Integer.parseInt(lc[1]);
        boolean[] visited = new boolean[c];

        alphas = br.readLine().split(" ");

        combi(0, 0, visited);

        answer.stream()
                .sorted()
                .forEach(System.out::println);
    }

    public static void combi(int count, int start, boolean[] visited) {
        if (count == l) {
            check(visited);
            return;
        }

        for (int i = start; i < c; i++) {
            visited[i] = true;
            combi(count+1, i+1, visited);
            visited[i] = false;
        }
    }

    public static void check(boolean[] visited) {
        int consonant = 0;
        int vowel = 0;
        char[] temp = new char[l];
        int count = 0;
        for (int i = 0; i < c; i++) {
            if (visited[i]) {
                if (alphas[i].equals("a") || alphas[i].equals("e") || alphas[i].equals("i") ||
                        alphas[i].equals("o") || alphas[i].equals("u")) {
                    vowel++;
                    temp[count++] = alphas[i].charAt(0);
                    continue;
                }
                consonant++;
                temp[count++] = alphas[i].charAt(0);
            }
        }

        if (consonant >= 2 && vowel >= 1) {
            Arrays.sort(temp);
            answer.add(String.valueOf(temp));
        }
    }
}
