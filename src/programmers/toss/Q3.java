package programmers.toss;

import java.util.*;

public class Q3 {

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        q3.solution(new String[]{
                "토스커피사일로&베이커리",
                "토스커피사일로 베이커리",
                "토스커피사일로 베이커",
                "토스커피사일로 베이",
                "토스커피사일",
                "비바리퍼블리카 식당",
                "비바리퍼블리카식",
                "비바리퍼블리"
        });
    }
    public String[] solution(String[] merchantNames) {
        String[] answer = {};

        Map<String, Queue<String>> map = new HashMap<>();

        for (String merchantName : merchantNames) {
            String s = merchantName.replaceAll("\\s", "");

            map.put(s, new PriorityQueue<>(Comparator.comparingInt(String::length)));
            System.out.println(s);
        }
        return answer;
    }
}
