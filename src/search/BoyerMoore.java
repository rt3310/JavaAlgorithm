package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoyerMoore {

    private static int matchCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String text = br.readLine();
        String pattern = br.readLine();
        List<Integer> indices = search(text, pattern);
        for (int i : indices) {
            sb.append(i + 1).append("\n");
        }

        System.out.println(matchCount);
        System.out.print(sb);
    }
    
    public static List<Integer> search(String text, String keyword) {
        List<Integer> indices = new ArrayList<>();

        Map<Character, Integer> skipTable = createSkipTable(keyword);

        int textPointer = keyword.length() - 1;
        while (textPointer > 0 && textPointer <= text.length()) {
            int keywordPointer = keyword.length() - 1;

            while (keywordPointer >= 0 && text.charAt(textPointer) == keyword.charAt(keywordPointer)) {
                textPointer--;
                keywordPointer--;
            }

            // 모두 일치했다면
            if (keywordPointer < 0) {
                indices.add(++textPointer);
                textPointer += keyword.length() + (keyword.length() - 1);
                matchCount++;
                continue;
            }

            // 일치하지 않았다면
            textPointer += skipTable.getOrDefault(text.charAt(textPointer), keyword.length());
        }

        return indices;
    }

    public static Map<Character, Integer> createSkipTable(String keyword) {
        Map<Character, Integer> skipTable = new HashMap<>();
        int count = keyword.length() - 1;
        for (char ch : keyword.toCharArray()) {
            skipTable.put(ch, count--);
        }
        return skipTable;
    }
}
