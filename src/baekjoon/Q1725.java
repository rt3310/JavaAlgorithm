package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1725 {

    private static int n;
    private static int[] arr;
    private static int[] tree;
    private static long maxArea;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        tree = new int[n * 4];
        maxArea = 0L;

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, n, 1);
        getMaxArea(1, n);

        System.out.print(maxArea);
    }

    public static int init(int start, int end, int idx) {
        if (start == end) {
            return tree[idx] = start;
        }

        int mid = (start + end) / 2;
        int left = init(start, mid, idx * 2);
        int right = init(mid + 1, end, idx * 2 + 1);
        if (arr[left] <= arr[right]) {
            return tree[idx] = left;
        }
        return tree[idx] = right;
    }

    public static int getMinIndex(int start, int end, int idx, int left, int right) {
        if (start > right || end < left) {
            return -1;
        }

        if (start >= left && end <= right) {
            return tree[idx];
        }

        int mid = (start + end) / 2;
        int leftMinIdx = getMinIndex(start, mid, idx * 2, left, right);
        int rightMinIdx = getMinIndex(mid + 1, end, idx * 2 + 1, left, right);
        if (leftMinIdx == -1) {
            return rightMinIdx;
        }
        if (rightMinIdx == -1) {
            return leftMinIdx;
        }
        if (arr[leftMinIdx] <= arr[rightMinIdx]) {
            return leftMinIdx;
        }
        return rightMinIdx;
    }

    public static void getMaxArea(int start, int end) {
        int minIdx = getMinIndex(1, n, 1, start, end);
        maxArea = Math.max(maxArea, (long) (end - start + 1) * (long) arr[minIdx]);

        if (start < minIdx) {
            getMaxArea(start, minIdx - 1);
        }
        if (end > minIdx) {
            getMaxArea(minIdx + 1, end);
        }
    }
}