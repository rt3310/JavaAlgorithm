package store;

public class    Pivonacci {

    public static void main(String[] args) {
        for (int i = 0; i < 47; i++) {
            System.out.printf("pivo(%d)=%d \n", i, pivo(i));
        }
    }

    public static int pivo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return pivo(n - 1) + pivo(n - 2);
    }
}
