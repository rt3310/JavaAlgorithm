package search;

public class UpperBound {

    public static void main(String[] args) {
        int[] array = {1, 3, 3, 3, 4, 6, 7, 7, 14, 14, 16, 20};
        int target = 7;

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            if (array[mid] <= target) {
                left = mid + 1;
                continue;
            }
            right = mid;
        }

        System.out.println("right = " + right);
        System.out.println("array[right] = " + array[right]);
    }
}
