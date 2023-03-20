package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String s1 = "";
        String s2 = new String("").intern();

        System.out.println(s1 == s2);
    }
}