package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5644 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static int m;
    private static int a;
    private static int[] aMove;
    private static int[] bMove;
    private static int[][] bcs;
    private static int[] bcLength;
    private static int[] bcPower;
    private static int sum;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");
            testCase();
        }
        System.out.println(sb);
    }

    public static void testCase() throws IOException {
        String[] ma = br.readLine().split(" ");
        m = Integer.parseInt(ma[0]);
        a = Integer.parseInt(ma[1]);
        aMove = new int[m + 1];
        bMove = new int[m + 1];
        bcLength = new int[a + 1];
        bcPower = new int[a + 1];
        bcs = new int[a + 1][2];
        sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            aMove[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            bMove[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= a; i++) {
            String[] bc = br.readLine().split(" ");
            int x = Integer.parseInt(bc[0]);
            int y = Integer.parseInt(bc[1]);
            int c = Integer.parseInt(bc[2]);
            int p = Integer.parseInt(bc[3]);
            bcs[i] = new int[]{y - 1, x - 1};
            bcLength[i] = c;
            bcPower[i] = p;
        }

        search();
        sb.append(sum).append("\n");
    }

    public static void search() {
        int[][] directions = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[] acur = {0, 0};
        int[] bcur = {9, 9};

        for (int i = 0; i <= m; i++) {
            int aRow = acur[0] + directions[aMove[i]][0];
            int aCol = acur[1] + directions[aMove[i]][1];
            int bRow = bcur[0] + directions[bMove[i]][0];
            int bCol = bcur[1] + directions[bMove[i]][1];

            List<int[]> aList = new ArrayList<>();
            List<int[]> bList = new ArrayList<>();

            for (int j = 1; j <= a; j++) {
                int bcDistanceToA = Math.abs(aRow - bcs[j][0]) + Math.abs(aCol - bcs[j][1]);
                int bcDistanceToB = Math.abs(bRow - bcs[j][0]) + Math.abs(bCol - bcs[j][1]);

                if (bcDistanceToA <= bcLength[j]) {
                    aList.add(new int[]{bcPower[j], j});
                }

                if (bcDistanceToB <= bcLength[j]) {
                    bList.add(new int[]{bcPower[j], j});
                }
            }

            if (aList.size() == 0) {
                aList.add(new int[]{0, -1});
            }
            if (bList.size() == 0) {
                bList.add(new int[]{0, -2});
            }

            int aSize = aList.size();
            int bSize = bList.size();

            Queue<Integer> combi = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
            for (int j = 0; j < aSize; j++) {
                for (int k = 0; k < bSize; k++) {
                    int[] aElem = aList.get(j);
                    int[] bElem = bList.get(k);

                    if (aElem[1] == bElem[1]) {
                        combi.offer((aElem[0] + bElem[0]) / 2);
                        continue;
                    }

                    combi.offer(aElem[0] + bElem[0]);
                }
            }

            if (!combi.isEmpty()) {
                sum += combi.poll();
            }

            acur = new int[]{aRow, aCol};
            bcur = new int[]{bRow, bCol};
        }
    }
}
