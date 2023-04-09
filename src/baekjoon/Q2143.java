package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2143 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Map<Long, Integer> aList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long total = 0;
                for (int k = i; k <= j; k++) {
                    total += a[k];
                }
                aList.put(total, aList.getOrDefault(total, 0) + 1);
            }
        }

        long answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                long total = 0;
                for (int k = i; k <= j; k++) {
                    total += b[k];
                }
                answer += aList.getOrDefault(t - total, 0);
            }
        }

        System.out.println(answer);
    }
}
