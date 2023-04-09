package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Q10810 {

    class Member {
        private String name;

        public Member(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[] numbers = new int[n];
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);
            for (int j = a - 1; j < b; j++) {
                numbers[j] = k;
            }
        }

        Function<String, Member> function = Member::new;

        for (int number : numbers) {
            sb.append(number).append(" ");
        }

        System.out.println(sb);
    }
}
