package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q14865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<long[]> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        String[] startXY = br.readLine().split(" ");
        long startX = Long.parseLong(startXY[0]);
        long startY = Long.parseLong(startXY[1]);
        long startDownX = 0;

        long prevX = startX;
        long prevY = startY;
        boolean isExist = false;
        long up = 0;
        for (int i = 1; i < n; i++) {
            String[] xy = br.readLine().split(" ");
            long x = Long.parseLong(xy[0]);
            long y = Long.parseLong(xy[1]);

            if (prevX == x && y > 0 && prevY <= 0) {
                up = x;
                isExist = true;
            } else if (isExist && prevX == x && y <= 0 && prevY > 0) {
                if (up > x) {
                    list.add(new long[] {x, up});
                } else {
                    list.add(new long[] {up, x});
                }
                isExist = false;
            }

            if (!isExist && prevX == x && y <= 0 && prevY > 0) {
                startDownX = x;
            }
            prevX = x;
            prevY = y;
        }

        if (prevX == startX && startY > 0 && prevY < 0) {
            up = startX;
            if (up < startDownX) {
                list.add(new long[]{up, startDownX});
            } else {
                list.add(new long[]{startDownX, up});
            }
        } else if (isExist && prevX == startX && startY < 0 && prevY > 0) {
            if (up > startX) {
                list.add(new long[] {startX, up});
            } else {
                list.add(new long[] {up, startX});
            }
        }

        list.sort(Comparator.comparingLong(e -> e[0]));

        int notContained = 0;
        int notContain = 0;
        int listSize = list.size();
        boolean[] contained = new boolean[listSize];
        for (int i = 0; i < listSize; i++) {
            long curRight = list.get(i)[1];

            boolean isContain = false;
            for (int j = i + 1; j < listSize; j++) {
                long otherRight = list.get(j)[1];
                if (otherRight < curRight) {
                    contained[j] = true;
                    isContain = true;
                }
            }

            if (!isContain) {
                notContain++;
            }
        }

        for (boolean isContained : contained) {
            if (!isContained) {
                notContained++;
            }
        }

        System.out.println(notContained + " " + notContain);
    }
}
