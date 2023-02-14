package structure.list;


public class Test {
    public static void main(String[] args) {
        CustomLinkedList<String> list = new CustomLinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("!!");

        System.out.println(list);

        print("12", 3, true);
    }

    public static void print(Object... args) {
        StringBuilder sb = new StringBuilder();

        for (Object arg : args) {
            sb.append(arg).append(" ");
        }

        System.out.println(sb);
    }
}
