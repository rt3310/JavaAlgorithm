package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q9019 {

    static class Dslr {
        private int number;
        private StringBuilder commands;

        public Dslr(int number, StringBuilder commands) {
            this.number = number;
            this.commands = commands;
        }

        public int getNumber() {
            return number;
        }

        public int getPopLeftNumber() {
            int popLeftDigit = number / 1000;
            int remainNumber = number % 1000;

            return remainNumber * 10 + popLeftDigit;
        }

        public int getPopRightNumber() {
            int popRightDigit = number % 10;
            int remainNumber = number / 10;

            return popRightDigit * 1000 + remainNumber;
        }

        public StringBuilder getCommands() {
            return commands;
        }
    }

    private static BufferedReader br;
    private static StringBuilder sb;
    private static int dest;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            testcase();
        }

        System.out.print(sb);
    }

    public static void testcase() throws IOException {
        String[] ab = br.readLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        dest = Integer.parseInt(ab[1]);

        search(a);
    }

    public static void search(int start) {
        Deque<Dslr> dq = new ArrayDeque<>();
        dq.offerLast(new Dslr(start, new StringBuilder()));
        boolean[] visited = new boolean[10000];
        visited[start] = true;

        while (!dq.isEmpty()) {
            Dslr dslr = dq.poll();
            String command = dslr.getCommands().toString();
            if (dslr.getNumber() == dest) {
                sb.append(command).append("\n");
                return;
            }

            int popLeftNumber = dslr.getPopLeftNumber();
            if (!visited[popLeftNumber]) {
                StringBuilder pushL = new StringBuilder(command).append("L");
                if (popLeftNumber == dest) {
                    sb.append(pushL).append("\n");
                    return;
                }
                visited[popLeftNumber] = true;
                dq.offerLast(new Dslr(popLeftNumber, pushL));
            }

            int popRightNumber = dslr.getPopRightNumber();
            if (!visited[popRightNumber]) {
                StringBuilder pushR = new StringBuilder(command).append("R");
                if (popRightNumber == dest) {
                    sb.append(pushR).append("\n");
                    return;
                }
                visited[popRightNumber] = true;
                dq.offerLast(new Dslr(popRightNumber, pushR));
            }

            int s = dslr.getNumber() - 1;
            if (s < 0) {
                s = 9999;
            }
            if (!visited[s]) {
                StringBuilder subOne = new StringBuilder(command).append("S");
                if (s == dest) {
                    sb.append(subOne).append("\n");
                    return;
                }
                visited[s] = true;
                dq.offerLast(new Dslr(s, subOne));
            }

            int d = (dslr.getNumber() * 2) % 10000;
            if (!visited[d]) {
                StringBuilder mulDouble = new StringBuilder(command).append("D");
                if (d == dest) {
                    sb.append(mulDouble).append("\n");
                    return;
                }
                visited[d] = true;
                dq.offerLast(new Dslr(d, mulDouble));
            }
        }
    }
}
