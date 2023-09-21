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

    int getValue(int mask, int r, int c) {
        int idx = (r << 2) + c;
        return (mask >> (idx << 2)) & 15;
    }

    void setValue(int mask, int r, int c, int value) {
        int idx = (r << 2) + c;
        mask = mask & ~(15 << (idx << 2)) | (value << (idx << 2));
        //            ...111100001111...      ...0000{value}0000...
    }

}