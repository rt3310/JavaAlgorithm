package store;

import java.util.Arrays;

public class SubSet {

    private static int[] numbers = {1, 2, 3};
    private static boolean[] visited;

    public static void main(String[] args) {
        visited = new boolean[numbers.length];

        search(0);
    }

    public static void search(int count) {
        if (count == numbers.length) {
            for (int i = 0; i < 3; i++) {
                if (visited[i]) {
                    System.out.print(numbers[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        visited[count] = true;
        search(count + 1);
        visited[count] = false;
        search(count + 1);
    }
}
