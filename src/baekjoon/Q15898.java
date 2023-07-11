package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15898 {

    static class Ingredient {
        private int efficacy;
        private String element;

        public Ingredient() {
        }

        public void setEfficacy(int efficacy) {
            this.efficacy = efficacy;
        }

        public void setElement(String element) {
            this.element = element;
        }

        public int getEfficacy() {
            return efficacy;
        }

        public String getElement() {
            return element;
        }
    }

    private static BufferedReader br;
    private static Ingredient[][][] ingredients;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ingredients = new Ingredient[n][4][4];
        for (int i = 0; i < n; i++) {
            testcase();
        }
    }

    public static void testcase() throws IOException {
        for (int i = 0; i < 4; i++) {
            String[] row = br.readLine().split(" ");
        }
    }
}
