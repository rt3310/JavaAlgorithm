package store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermTest {
    static int[] p = {1, 2, 3, 4, 5};
    static int N = p.length;
    static int R;
    static List<Integer> nums;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {
        R = 3;
        nums = new ArrayList<>();
        visited = new boolean[N];
        count = 0;

        perm(0);
        System.out.println(count);
    }

    private static void perm(int cnt) {
        if (cnt == R) {
            count++;
            System.out.println(Arrays.toString(nums.toArray()));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            nums.add(p[i]);
            perm(cnt + 1);
            nums.remove(nums.size() - 1);
            visited[i] = false;
        }
    }




}
