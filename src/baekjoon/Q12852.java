package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q12852 {

    static class Store {
        private int number;
        private int count;
        List<Integer> numbers;

        public Store(int number, int count, List<Integer> numbers) {
            this.number = number;
            this.count = count;
            this.numbers = new ArrayList<>(numbers);
        }

        public int getNumber() {
            return number;
        }

        public int getCount() {
            return count;
        }

        public List<Integer> getNumbers() {
            return numbers;
        }

        public void addNumber(int number) {
            this.numbers.add(number);
        }
    }

    private static int n;
    private static int minNumber;
    private static int[] minResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        search(n);
    }

    public static void search(int start) {
        StringBuilder sb = new StringBuilder();
        int[] visited = new int[start + 1];
        Deque<Store> dq = new ArrayDeque<>();
        dq.offerLast(new Store(start, 0, List.of(start)));
        visited[start] = 1;

        int result = 0;
        while (!dq.isEmpty()) {
            Store cur = dq.pollFirst();
            int curNum = cur.getNumber();
            int count = cur.getCount();
            List<Integer> numbers = cur.getNumbers();

            if (curNum == 1) {
                result = count;
                for (int number : numbers) {
                    sb.append(number).append(" ");
                }
                break;
            }

            if (curNum % 3 == 0) {
                if (visited[curNum / 3] == 0 || visited[curNum / 3] > count + 1) {
                    Store store = new Store(curNum / 3, count + 1, numbers);
                    store.addNumber(curNum / 3);
                    dq.offerLast(store);
                    visited[curNum / 3] = count + 1;
                }
            }

            if (curNum % 2 == 0) {
                if (visited[curNum / 2] == 0 || visited[curNum / 2] > count + 1) {
                    Store store = new Store(curNum / 2, count + 1, numbers);
                    store.addNumber(curNum / 2);
                    dq.offerLast(store);
                    visited[curNum / 2] = count + 1;
                }
            }

            if (curNum - 1 > 0) {
                if (visited[curNum - 1] == 0 || visited[curNum - 1] > count + 1) {
                    Store store = new Store(curNum - 1, count + 1, numbers);
                    store.addNumber(curNum - 1);
                    dq.offerLast(store);
                    visited[curNum - 1] = count + 1;
                }
            }
        }

        System.out.println(result);
        System.out.println(sb);
    }
}
