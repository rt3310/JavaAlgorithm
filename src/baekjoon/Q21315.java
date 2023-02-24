package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q21315 {

    private static int n;
    private static Deque<Integer> dq;
    private static Deque<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dq = new ArrayDeque<>();
        answer = new ArrayDeque<>();

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            dq.offerLast(i);
        }

        int k = getK(n);
        System.out.println(search(k));
//        for (int i = 1; i <= k; i++) {
//            System.out.println(search(i));
//        }
    }

    public static Deque<Integer> search(int k) {
        Deque<Integer> temp = new ArrayDeque<>();
        Deque<Integer> mid = new ArrayDeque<>();

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < (1 << i); j++) {
                if (dq.isEmpty()) {
                    break;
                }
                mid.offerFirst(dq.pollLast());
            }

            while (!mid.isEmpty()) {
                temp.offerLast(mid.pollFirst());
            }
        }

        return temp;
    }

    // 1 2 3 4 5 -> 2 3 4 5 1 -> 4 5 2 3 1 -> 5 4 2 3 1 -> 3 1 5 4 2 -> 1 3 5 4 2

    private static int getK(int count) {
        for (int i = 1; i < 10; i++) {
            if ((1 << i) >= count) {
                return i - 1;
            }
        }
        return 9;
    }
}
