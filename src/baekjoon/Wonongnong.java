package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Wonongnong {
    private static int[][] arr;
    private static int n; //행
    private static int m; //열
    private static int count; //초

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rck = br.readLine().split(" ");
        int r = Integer.parseInt(rck[0]) - 1;
        int c = Integer.parseInt(rck[1]) - 1;
        int k = Integer.parseInt(rck[2]);

        //처음 배열 초기화
        n = 3;
        m = 3;
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] col = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(col[j]);
            }
        }

        while (true) {
            //인덱스가 넘어가는 경우도 생각
            if (r < n && c < m && arr[r][c] == k) {
                System.out.println(count);
                break;
            }
            //100초가 지나도 k가 되지 않을 때
            if (count > 100) {
                System.out.println(-1);
                break;
            }

            if (n >= m) {
                r();
            } else {
                c();
            }
        }

    }

    //모든 행에 대해서 정렬
    public static void r() {
        int max = 0; //늘어난 열 중 크기가 제일 큰 열
        count++;
        List<List<Integer>> sortLists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] colArr = arr[i];

            List<Integer> list = arrSort(colArr);
            sortLists.add(list);

            max = Math.max(list.size(), max);
        }
        m = max;

        newArr(true, sortLists);
    }

    //모든 열에 대해서 정렬
    public static void c() {
        int max = 0;
        count++;
        List<List<Integer>> sortLists = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> rowArr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                rowArr.add(arr[j][i]);
            }

            List<Integer> list = arrSort(rowArr.stream().mapToInt(a -> a).toArray());
            sortLists.add(list);

            max = Math.max(list.size(), max);
        }
        n = max;

        newArr(false, sortLists);
    }

    //정렬
    public static List<Integer> arrSort(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        //map 초기화
        for (int a : arr) {
            if (a == 0) {
                continue;
            }
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());

        //map value값 정렬
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });

        List<Integer> sortArr = new ArrayList<>();

        for (int key : keySet) {
            sortArr.add(key);
            sortArr.add(map.get(key));
        }

        return sortArr;
    }

    public static void newArr(boolean isCol, List<List<Integer>> list) {
        arr = new int[n][m];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (isCol) {
                    arr[i][j] = list.get(i).get(j);
                    continue;
                }
                arr[j][i] = list.get(i).get(j);
            }
        }
    }
}