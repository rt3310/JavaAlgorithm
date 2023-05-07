import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        int number = 6;
        System.out.println(Integer.toBinaryString(number));
        System.out.println(Integer.toBinaryString(-number));
        System.out.println(Integer.toBinaryString(number & -number));
        System.out.println(Integer.toBinaryString(number + (number & -number)));
    }
}
