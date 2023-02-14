package store;

import java.util.Calendar;

public class MyCalendar {
    public static void main(String[] args) {
        calculate(2023);
    }

    public static void calculate(int year) {
        for (int i = 1; i <= 12; i++) {
            calculate(year, i);
            System.out.println();
            System.out.println();
        }
    }

    public static void calculate(int year, int month) {
        String a = "일\t월\t화\t수\t목\t금\t토";
        String b = String.format("\t%d년\t%d월", year, month);
        Calendar cal = Calendar.getInstance();
        cal.set(year, month-1, 1);
        System.out.println(b);
        System.out.println(a);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 요일 1~7
        for (int i = 1; i < dayOfWeek; i++) {
            System.out.print("\t");
        }
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= lastDay; i++) {
            System.out.printf("%d\t", i);
            if ((dayOfWeek-1+i) % 7 == 0) {
                System.out.println();
            }
        }
    }
}
