package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int total = 2097151;
        System.out.println(Integer.toBinaryString(total & (1 << 10)));
    }
}