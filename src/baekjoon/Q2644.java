package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Q2644 {
    static int N, M, a, b;
    private static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        visited = new int[101];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            arr[child] = parent;
        }

        System.out.println(solve(arr));

    }

    static int solve(int[] arr) {
        //a 부모 리스트
        int index = a;
        int count = 1;
        visited[index] = count++;
        while (arr[index] != 0) {
            visited[arr[index]] = count++;
            index = arr[index];
        }

        //b 부모 리스트
        index = b;
        count = 1;
        if (visited[index] != 0) {
            return visited[index] + count - 2;
        }
        visited[index] = count++;
        while (arr[index] != 0) {
            if (visited[arr[index]] != 0) {
                return visited[arr[index]] + count - 2;
            }
            visited[arr[index]] = count++;
            index = arr[index];
        }

        return -1;
    }
}