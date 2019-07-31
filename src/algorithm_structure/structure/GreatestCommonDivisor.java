package algorithm_structure.structure;

/**
 * @Author: dell
 * @Date: 2019/7/31 14:52
 */
public class GreatestCommonDivisor {
    public static long gcd(long m, long n) {
        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }
}
