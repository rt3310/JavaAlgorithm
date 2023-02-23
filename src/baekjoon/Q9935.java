package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String deleteStr = br.readLine();

        while (true) {
            String encodedStr = boom(str, deleteStr);

            if (encodedStr.equals("")) {
                System.out.println("FRULA");
                break;
            }

            if (str.equals(encodedStr)) {
                System.out.println(str);
                break;
            }
            str = encodedStr;
        }
    }

    public static String boom(String str, String deleteStr) {
        StringBuilder sb = new StringBuilder();
        int strLength = str.length();
        int deleteStrLength = deleteStr.length();

        int idx = 0;
        while (idx < strLength - deleteStrLength + 1) {
            if (str.substring(idx, idx + deleteStrLength).equals(deleteStr)) {
                idx += deleteStrLength;
                continue;
            }
            sb.append(str.charAt(idx));
            idx++;
        }
        sb.append(str.substring(idx));
        if (sb.toString().equals(deleteStr)) {
            return "";
        }
        return sb.toString();
    }
}
