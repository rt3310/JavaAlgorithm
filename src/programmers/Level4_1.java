package programmers;

import java.util.HashMap;
import java.util.Map;

public class Level4_1 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"go", "gone", "guild"}));
        System.out.println(solution(new String[]{"abc", "def", "ghi", "jklm"}));
        System.out.println(solution(new String[]{"word", "war", "warrior", "world"}));
    }
    
    public static int solution(String[] words) {
        int answer = 0;
        Map<String, Integer> counts = new HashMap<>();

        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                String substring = word.substring(0, i);
                counts.put(substring, counts.getOrDefault(substring, 0) + 1);
            }
        }

        for (String word : words) {
            int count = 0;
            boolean isPut = false;
            for (int i = 1; i <= word.length(); i++) {
                count++;
                if (counts.get(word.substring(0, i)) == 1) {
                    answer += count;
                    isPut = true;
                    break;
                }
            }

            if (!isPut) {
                answer += count;
            }
        }

        return answer;
    }
}
