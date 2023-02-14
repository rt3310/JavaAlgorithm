package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = {5, 7, 3, 8, 2, 4, 1, 6};
        mergeSort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merging(arr, start, mid, mid + 1, end);
    }

    public static void merging(int[] arr, int start1, int end1, int start2, int end2) {
        int[] temp = new int[end2 - start1 + 1];
        int s1 = start1;
        int s2 = start2;
        int count = 0;
        while (s1 <= end1 && s2 <= end2) {
            if (arr[s1] < arr[s2]) {
                temp[count++] = arr[s1++];
                continue;
            }
            temp[count++] = arr[s2++];
        }

        while (s1 <= end1) {
            temp[count++] = arr[s1++];
        }

        while (s2 <= end2) {
            temp[count++] = arr[s2++];
        }

        if (count >= 0) System.arraycopy(temp, 0, arr, start1, count);
    }
}
