package baekjoon;

import java.util.HashMap;
import java.util.Objects;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

public class Test {

    public static void main(String[] args) {
        String s1 = new String("ABC");
        String s2 = new String("ABC");
        System.out.println(s1.equals(s2)); // false
        System.out.println(s1.hashCode()); // 96
        System.out.println(s2.hashCode()); // 96

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(s1, 1);
        hashMap.put(s2, 2);

        System.out.println(hashMap.size()); // 1
        System.out.println(hashMap.get(s1)); // 2
        System.out.println(hashMap.get(s2)); // 2
    }
}
