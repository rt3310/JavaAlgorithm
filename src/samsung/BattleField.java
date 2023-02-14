package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BattleField {
    private static BufferedReader br;
    private static Map<String, String> view;
    private static Map<String, Integer> direction;
    private static int h;
    private static int w;
    private static int n;
    private static String[][] map;
    private static String[] commands;
    private static int[] tank;
    private static int curDirect;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        view = new HashMap<>();
        view.put("U", "^");
        view.put("L", "<");
        view.put("D", "v");
        view.put("R", ">");

        direction = new HashMap<>();
        direction.put("U", 0);
        direction.put("L", 1);
        direction.put("D", 2);
        direction.put("R", 3);

        for (int i = 1; i <= t; i++) {
            testCase(i);
        }
    }

    public static void testCase(int count) throws IOException {
        String[] hw = br.readLine().split(" ");
        h = Integer.parseInt(hw[0]);
        w = Integer.parseInt(hw[1]);
        map = new String[h][w];
        tank = new int[]{-1, -1};

        for (int i = 0; i < h; i++) {
            String[] row = br.readLine().split("");
            map[i] = row;

            if (tank[0] != -1) {
                continue;
            }

            for (int j = 0; j < w; j++) {
                if (row[j].equals("^")) {
                    tank = new int[]{i, j};
                    curDirect = 0;
                    break;
                }
                if (row[j].equals("<")) {
                    tank = new int[]{i, j};
                    curDirect = 1;
                    break;
                }
                if (row[j].equals("v")) {
                    tank = new int[]{i, j};
                    curDirect = 2;
                    break;
                }
                if (row[j].equals(">")) {
                    tank = new int[]{i, j};
                    curDirect = 3;
                    break;
                }
            }
        }

        n = Integer.parseInt(br.readLine());
        commands = br.readLine().split("");

        search();

        StringBuilder sb = new StringBuilder("#" + count + " ");
        for (String[] mapRow : map) {
            for (String mapDot : mapRow) {
                sb.append(mapDot);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void search() {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (String command : commands) {
            if (command.equals("S")) {
                int curRow = tank[0];
                int curCol = tank[1];
                while (true) {
                    int row = curRow + directions[curDirect][0];
                    int col = curCol + directions[curDirect][1];

                    if (row < 0 || row >= h || col < 0 || col >= w) {
                        break;
                    }

                    if (map[row][col].equals("#")) {
                        break;
                    }

                    if (map[row][col].equals("*")) {
                        map[row][col] = ".";
                        break;
                    }

                    curRow = row;
                    curCol = col;
                }
                continue;
            }

            map[tank[0]][tank[1]] = view.get(command);
            curDirect = direction.get(command);
            int row = tank[0] + directions[curDirect][0];
            int col = tank[1] + directions[curDirect][1];

            if (row < 0 || row >= h || col < 0 || col >= w) {
                continue;
            }

            if (map[row][col].equals("*") || map[row][col].equals("#") || map[row][col].equals("-")) {
                continue;
            }

            map[row][col] = view.get(command);
            map[tank[0]][tank[1]] = ".";
            tank = new int[]{row, col};
        }
    }
}
