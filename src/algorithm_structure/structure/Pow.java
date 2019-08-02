package algorithm_structure.structure;

/**
 * @Author: dell
 * @Date: 2019/7/31 15:28
 */
public class Pow {
    public static long pow(long x, int n) {
        if (n == 0) {
            return 1;
        }
//        if (n == 1) {
//            return x;
//        }
        if (isEven(n)) {
            return pow(x * x, n / 2);
        } else {
//            return pow(x * x, n / 2) * x;
            return pow(x, n - 1) * x;
        }
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
