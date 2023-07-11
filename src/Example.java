import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example {

    private static boolean[] visited;
    private static int[] permutation;
    private static int n = 5;
    private static int r = 3;


    // 스택!!!!
    // 재귀 -> 스택!!!!
    public static void main(String[] args) {
        visited = new boolean[6];
        permutation = new int[r];

        dfs(0);
    }

    public static void dfs(int index) {
        if (index == r) {
            System.out.println(Arrays.toString(permutation));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            permutation[index] = i;
            dfs(index + 1);
            visited[i] = false;
        }
    }
}
