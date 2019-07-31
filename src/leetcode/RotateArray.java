package leetcode;

import java.util.Arrays;

public class RotateArray {
    
    public static void rotate(int[] nums, int k) {
//        for(int i = 0; i < k; i++) {
//            // 记录要旋转到左边的值
//            int p = nums[nums.length-1];
//            // 将数组左边的值都往挪动一位
//            for(int j = nums.length-1; j > 0; j--) {
//                nums[j] = nums[j-1];
//            }
//            // 将旋转的值放到数组开头
//            nums[0] = p; 
//        }
        
        // 创建一个数组， 包含所有需要旋转的值
        int[] p = new int[k];
        int j = 0;
        for(int i = nums.length-1; i > nums.length-1 - k; i-- ) {
            
            p[j++] = nums[i];
        }
        // 把数组剩下的 元素往后挪动
        for(int i = nums.length-1; i >= k; i--) {
            nums[i] = nums[i-k];
        }
        
        j = p.length-1;
        // 将旋转的值保存到数组前部
        for(int i = 0; i < k; i++) {
            nums[i] = p[j--];
        }
        
        
        
    }     
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

}
