package structure.tree.segment;

import java.util.Arrays;

public class SegmentTree {

    private static int[] arr;
    private static int[] tree;

    public static void main(String[] args) {
        arr = new int[]{5, 6, 9, 3, 8, 2, 5, 1, 4, 7};
        tree = new int[arr.length * 4];

        init(0, arr.length - 1, 1);
        System.out.println(Arrays.toString(tree));
        update(0, arr.length - 1, 1, 2, 1);
        System.out.println(Arrays.toString(tree));
        System.out.println(intervalSum(0, arr.length - 1, 1, 1, 2));
    }
    public static int init(int start, int end, int nodeIndex) {
        if (start == end) {
            return tree[nodeIndex] = arr[start];
        }

        int mid = (start + end) / 2;

        return tree[nodeIndex] = init(start, mid, nodeIndex * 2) + init(mid + 1, end, nodeIndex * 2 + 1);
    }

    // start: 시작 인덱스, end: 끝 인덱스
    // left, right: 구간 합 범위
    public static int intervalSum(int start, int end, int nodeIndex, int left, int right) {
        // 범위 밖에 있는 경우
        if (left > end || right < start) {
            return 0;
        }

        // 범위 안에 있는 경우
        if (left <= start && right >= end) {
            return tree[nodeIndex];
        }

        // 그렇지 않으면 두 부분으로 나누어 합 구하기
        int mid = (start + end) / 2;
        return intervalSum(start, mid, nodeIndex * 2, left, right) + intervalSum(mid + 1, end, nodeIndex * 2 + 1, left, right);
    }

    public static void update(int start, int end, int nodeIndex, int updateIndex, int src) {
        if (updateIndex < start || updateIndex > end) {
            return;
        }
        tree[nodeIndex] += src - arr[updateIndex];

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, nodeIndex * 2, updateIndex, src);
        update(mid + 1, end, nodeIndex * 2 + 1, updateIndex, src);
    }
}
