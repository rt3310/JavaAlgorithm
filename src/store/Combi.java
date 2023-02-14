package store;

public class Combi {
    public static void main(String[] args) {
        for (int i = 0; i < 21; i++) {
            System.out.printf("20C%d=%d\n", i, nCr(20, i));
        }
    }

    public static int nCr(int n, int r) {
        if (n == r) {
            return 1;
        }
        if (r == 0) {
            return 1;
        }
        return nCr(n - 1, r - 1) + nCr(n - 1, r);
    }
}
