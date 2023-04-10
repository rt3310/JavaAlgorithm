package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2263 {

    private static int n;
    private static int[] inOrder;
    private static int[] postOrder;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        search(0, n - 1, 0, n - 1);

        System.out.println(sb);
    }

    public static void search(int left, int right, int inLeft, int inRight) {
        if (left >= right) {
            if (left == right) {
                sb.append(postOrder[left]).append(" ");
            }
            return;
        }

        int parent = postOrder[right];
        sb.append(parent).append(" ");
        int index = getIndexAtInOrder(parent, inLeft, inRight);
        int leftSize = index - inLeft;
        int rightSize = inRight - index;

        search(left, right - rightSize - 1, inLeft, index - 1);
        search(right - rightSize, right - 1, index + 1, inRight);
    }

    public static int getIndexAtInOrder(int number, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (inOrder[i] == number) {
                return i;
            }
        }
        return -1;
    }
}

// 인오더: ((1 3 (4 5 6)) 7 (12 15 16))
// 포스트오더: ((1 (4 6 5) 3) (12 16 15) 7)
// 프리오더: (7 (3 1 (5 4 6)) (15 12 16))