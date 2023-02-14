package store;

public class BitMasking {
    public static void main(String[] args) {
        // 수의 크기를 기준으로 탐색    15 = 1111
        int number = 15;

        for (int subset = number; subset > 0; subset = (subset - 1) & number) {
            System.out.println(Integer.toBinaryString(subset));
        }

        // 자리 수를 기준으로 탐색    4 = 1111(4자리)
        int length = 4;

        for (int subset = 0; subset < (1 << length); subset++) {
            System.out.println(Integer.toBinaryString(subset));
        }
    }
}