package store;

public class Distance {

    public static void main(String[] args) {
        int[] start = {1, 1};
        int[] end = {2, 2};

        int a = Math.abs(end[0] - start[0]);
        int b = Math.abs(end[1] - start[1]);

        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        double radian = Math.atan(b / a);
        System.out.println("radian = " + radian);

        double degree = Math.toDegrees(radian);
        System.out.println("degree = " + degree);
    }

    public static void filter() {

    }
}
