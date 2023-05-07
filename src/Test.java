import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {
        boolean[] check = new boolean[46];
        List<Integer> lotto = new ArrayList<>();

        int count = 0;
        Random random = new Random();
        while (count < 6) {
            int number = random.nextInt(45);
            if (!check[number]) {
                check[number] = true;
                lotto.add(number);
                count++;
            }
        }

        Collections.sort(lotto);
        System.out.println(lotto);
    }

}
