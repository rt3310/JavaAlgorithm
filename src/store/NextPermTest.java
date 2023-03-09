package store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NextPermTest {
    static int[] p = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int count;
    static int N = p.length;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int start = (int) Math.pow(10, (n-1)) + 1;
        int end = (int) Math.pow(10, n) - 1;

        do {
            System.out.println(Arrays.toString(p));
        } while (np(3));


        System.out.println(count);
    }

    static boolean np(int size) {
        int pivot = size;
        while (pivot > 0 && p[pivot - 1] > p[pivot]) {
            pivot--;
        }

        if (pivot == 0) {
            return false;
        }

        int oppo = size;
        while (p[pivot - 1] > p[oppo]) {
            oppo--;
        }
        int temp = p[pivot - 1];
        p[pivot - 1] = p[oppo];
        p[oppo] = temp;
        int k = size;
        while (pivot < k) {
            temp = p[pivot];
            p[pivot] = p[k];
            p[k] = temp;
            pivot++;
            k--;
        }
        return true;
    }
}
