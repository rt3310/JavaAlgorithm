package search.tree;

import java.util.Arrays;

public class Preorder {

    private static int[] arr;
    private static int[] tree;

    public static void main(String[] args) {
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        tree = new int[arr.length * 4];

        System.out.println(Arrays.toString(tree));
    }
}
