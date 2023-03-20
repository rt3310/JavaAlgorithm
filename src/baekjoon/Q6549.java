package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6549 {
    
    private static int n;
    private static int[] arr;
    private static int[] tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            arr = new int[n + 1];
            tree = new int[n * 4];

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            init(1, n, 1);

            int max = 0;
            int left = 1;
            int right = n;
            while (left <= right) {
                int width = right - left + 1;
                int height = getMinInInterval(1, n, 1, left, right);
                max = Math.max(max, width * height);

                if (arr[left] < arr[right]) {
                    left++;
                    continue;
                }
                right--;
            }

            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }

    public static int init(int start, int end, int idx) {
        if (start == end) {
            return tree[idx] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[idx] = Math.min(init(start, mid, idx * 2), init(mid + 1, end, idx * 2 + 1));
    }

    public static int getMinInInterval(int start, int end, int idx, int left, int right) {
        if (end < left || start > right) {
            return Integer.MAX_VALUE;
        }

        if (start >= left && end <= right) {
            return tree[idx];
        }

        int mid = (start + end) / 2;
        return Math.min(getMinInInterval(start, mid, idx * 2, left, right), getMinInInterval(mid + 1, end, idx * 2 + 1, left, right));
    }
}
