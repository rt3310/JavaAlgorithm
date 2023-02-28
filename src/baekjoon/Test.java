package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] inputs = new String[N];
        String[] outputs = new String[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) { // alias 정할 닉네임
            int index = 0;
            int cnt = 1;
            for (int j = 0; j < i; j++) { // 비교할 닉네임
                if (inputs[i].equals(inputs[j])) {
                    cnt++;
                }

                if (cnt > 1)
                    continue;

                for (int k = index; k < inputs[i].length(); k++) {
                    index = k;

                    if (inputs[j].length()-1 < k) {
                        break;
                    }

                    char c = inputs[i].charAt(k);

                    if (c != inputs[j].charAt(k)) {
                        break;
                    }
                }
            }

            if (cnt > 1) {
                outputs[i] = inputs[i] + cnt;
            }
            else
                outputs[i] = inputs[i].substring(0, index+1);
        }

        for (int i = 0; i < N; i++) {
            System.out.println(outputs[i]);
        }
    }
}