package structure.tree.fenwick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FenwickTree {

    private static long[] arr;
    private static long[] tree;
    private static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        arr = new long[n + 1];
        tree = new long[n * 2];
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            update(i, arr[i]);
        }


        for (int i = 0; i < m + k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int a1 = Integer.parseInt(st.nextToken());
                long b1 = Long.parseLong(st.nextToken());

                long diff = b1 - arr[a1];
                arr[a1] = b1;
                update(a1, diff);
                continue;
            }

            int a2 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());

            sb.append(sum(b2) - sum(a2 - 1)).append("\n");
        }

        System.out.print(sb);
    }

    public static void update(int index, long diff) {
        while (index <= n) {
            tree[index] += diff;
            index += (index & -index);
        }
    }

    public static long sum(int index) {
        long answer = 0;
        while (index > 0) {
            answer += tree[index];
            index -= (index & -index);
        }

        return answer;
    }
}
