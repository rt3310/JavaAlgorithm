package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q16500 {

    private static String s;
    private static int sLength;
    private static int n;
    private static String[] strs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        sLength = s.length();

        n = Integer.parseInt(br.readLine());
        strs = new String[n];

        for (int i = 0; i < n; i++) {
            strs[i] = br.readLine();
        }

    }
}
