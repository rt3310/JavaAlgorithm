package search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 6, 7, 9, 10, 11, 14, 16, 17, 20};
        int target = 16;

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                System.out.println("mid = " + mid);
                System.out.println("array[mid] = " + array[mid]);
                break;
            }

            if (array[mid] < target) {
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
    }
}
