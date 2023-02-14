package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] numbers = {5, 7, 3, 8, 2, 4, 1, 6};
        quickSort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && arr[left] < arr[pivot]) {
                left++;
            }

            while (right >= start && arr[right] > arr[pivot]) {
                right--;
            }

            if (left > right) {
                swap(arr, right, pivot);
                continue;
            }
            swap(arr, left, right);
        }

        quickSort(arr, start, right);
        quickSort(arr, right + 1, end);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
