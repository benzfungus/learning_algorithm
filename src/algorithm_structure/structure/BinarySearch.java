package algorithm_structure.structure;

/**
 * @Author: dell
 * @Date: 2019/7/31 14:39
 */
public class BinarySearch {

    /**
     * Performs the standard binary search
     *
     * @param a
     * @param x
     * @param <T>
     * @return index where item is found, or -1 if not found
     */
    public static <T extends Comparable<? super T>> int binarySearch(T[] a, T x) {
        int low = 0;
        int high = a.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid].compareTo(x) < 0){
                low = mid + 1;
            }else if(a[mid].compareTo(x) > 0){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
