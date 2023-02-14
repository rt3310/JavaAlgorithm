package store;

public class Hanoi {
    public static void main(String[] args) {
        hanoi(3, 1, 2, 3);
    }

    public static void hanoi(int cnt, int start, int mid, int end) {
        if (cnt == 0) {
            return;
        }

        hanoi(cnt - 1, start, end, mid);
        System.out.println(cnt + " : " + start + " -> " + end);
        hanoi(cnt - 1, mid, start, end);
    }
}
