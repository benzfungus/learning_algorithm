package algorithm_structure.structure;

/**
 * @Author: dell
 * @Date: 2019/7/31 13:27
 */
public class MaximumContiguousSubsequence {

    /**
     * Cubic maximum contiguous subsequence sum algorithm
     * 立方级最大子序列算法
     */
    public static int maxSubSum1(int[] a) {
        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;

                for (int k = i; k < j + 1; k++) {
                    thisSum += a[k];
                }
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }

        return maxSum;
    }

    /**
     * Quadratic maximum contiguous subsequence sum algorithm
     * 平方级最大子序列算法
     *
     * @param a
     * @return
     */
    public static int maxSubSum2(int[] a) {
        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * Recursive maximum contiguous subsequence sum algorithm
     * Finds maximum sum in subarray spanning a[left..right]
     * Does not attempt to maintain actual best sequence
     * 递归最大连续子序列和算法
     * 在[left..right]中找到子阵列中的最大和
     * 不尝试保持实际的最佳序列
     */
    private static int maxSumRec(int[] a, int left, int right) {
        // base case
        if (left == right) {
            if (a[left] > 0) {
                return a[left];
            } else {
                return 0;
            }
        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center+1, right);

        int maxLeftBorderSum = 0;
        int leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum){
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0;
        int rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if(rightBorderSum > maxRightBorderSum){
                maxRightBorderSum = rightBorderSum;
            }
        }
        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int maxLeftSum, int maxRightSum, int i) {
        if(maxLeftSum > maxRightSum && maxLeftSum > i){
            return maxLeftSum;
        }
        if(maxRightSum > maxLeftSum && maxRightSum > i){
            return maxRightSum;
        }
        if(i > maxLeftSum && i > maxRightSum){
            return i;
        }
        return 0;
    }

    /**
     * Driver for divide-and-conquer maximum contiguous
     * subsequence sum algorithm
     */
    public static int maxSubSum3(int[] a){
        return maxSumRec(a, 0, a.length-1);
    }

    /**
     * Linear-time maximum contiguous subsequence sum algorithm
     * 线性级别最大子序列算法
     * @param a
     * @return
     */
    public static int maxSubSum4(int[] a){
        int maxSum = 0;
        int thisSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];

            if(thisSum > maxSum){
                maxSum = thisSum;
            }else if( thisSum < 0){
                thisSum = 0;
            }
        }
        return maxSum;
    }

}
