package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] users = new int[n][2];
        String[] userNames = new String[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            users[i] = new int[]{Integer.parseInt(input[0]), i};
            userNames[i] = input[1];
        }

        Arrays.sort(users, (v1, v2) -> {
            if (v1[0] == v2[0]) {
                return v1[1] - v2[1];
            }
            return v1[0] - v2[0];
        });

        for (int[] user: users) {
            sb.append(user[0]).append(" ").append(userNames[user[1]]).append("\n");
        }

        System.out.print(sb);
    }
}
