package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11723 {

    private static int checkNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        checkNumber = 0;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("all")) {
                checkNumber = 2097151;
                continue;
            }

            if (command.equals("empty")) {
                checkNumber = 0;
                continue;
            }

            int x = Integer.parseInt(st.nextToken());

            if (command.equals("check")) {
                sb.append((checkNumber & (1 << x)) == 0 ? 0 : 1).append("\n");
                continue;
            }

            switch (command) {
                case "add":
                    checkNumber = checkNumber | (1 << x);
                    break;
                case "remove":
                    checkNumber = checkNumber & ~(1 << x);
                    break;
                case "toggle":
                    checkNumber = checkNumber ^ (1 << x);
                    break;
            }
        }

        System.out.println(sb);
    }
}
