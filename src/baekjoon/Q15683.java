package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15683 {

    private static int n;
    private static int m;
    private static String[][] map;
    private static List<int[]> cctvs;
    private static int cctvCount;
    private static int[] visited;
    private static int minBlindSpot;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cctvs = new ArrayList<>();
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        map = new String[n][m];
        cctvCount = 0;
        minBlindSpot = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                String e = st.nextToken();
                map[i][j] = e;

                if (e.equals("0") || e.equals("6")) {
                    continue;
                }
                
                cctvCount++;
                cctvs.add(new int[]{i, j});
            }
        }
        visited = new int[cctvCount];
        for (int i = 0; i < cctvCount; i++) {
            visited[i] = -1;
        }

        search(0);
        System.out.println(minBlindSpot);
    }

    public static void search(int count) {
        if (count == cctvCount) {
            minBlindSpot = Math.min(minBlindSpot, getCountBlindSpot(setAllCCTVView()));
            return;
        }

        int[] cctv = cctvs.get(count);
        if (map[cctv[0]][cctv[1]].equals("5")) {
            visited[count] = 0;
            search(count + 1);
            visited[count] = -1;
        } else {
            for (int j = 0; j < 4; j++) {
                visited[count] = j;
                search(count + 1);
                visited[count] = -1;
            }
        }
    }
    
    public static int getCountBlindSpot(String[][] copy) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j].equals("0")) {
                    count++;
                }
            }
        }

        return count;
    }

    private static String[][] setAllCCTVView() {
        String[][] copy = new String[n][m];

        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(map[i], m);
        }
        
        for (int i = 0; i < cctvCount; i++) {
            int[] cctv = cctvs.get(i);

            setCCTVView(copy, cctv, map[cctv[0]][cctv[1]], visited[i]);
        }

        return copy;
    }
    
    public static void setCCTVView(String[][] copy, int[] cctv, String type, int direction) {
        int[][] viewDirections = getViewDirection(type, direction);
        for (int[] viewDirection : viewDirections) {
            int curRow = cctv[0] + viewDirection[0];
            int curCol = cctv[1] + viewDirection[1];
            while (curRow >= 0 && curRow < n && curCol >= 0 && curCol < m) {
                if (copy[curRow][curCol].equals("6")) {
                    break;
                }

                if (!copy[curRow][curCol].equals("0")) {
                    curRow += viewDirection[0];
                    curCol += viewDirection[1];
                    continue;
                }

                copy[curRow][curCol] = "#";
                curRow += viewDirection[0];
                curCol += viewDirection[1];
            }
        }
    }

    private static int[][] getViewDirection(String type, int direction) {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        if (type.equals("1")) {
            return new int[][]{directions[direction]};
        }

        if (type.equals("2")) {
            return new int[][]{directions[direction], directions[(direction + 2) % 4]};
        }

        if (type.equals("3")) {
            return new int[][]{directions[direction], directions[(direction + 1) % 4]};
        }

        if (type.equals("4")) {
            return new int[][]{directions[direction], directions[(direction + 1) % 4], directions[(direction + 2) % 4]};
        }
        return directions;
    }
}
