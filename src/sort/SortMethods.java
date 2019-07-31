package sort;
import java.util.Arrays;

public class SortMethods {
    
    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            // 拿出要插入的值
            int key = arr[i];
            int j = i-1;
            // 判断前面的值是否大于key，大于的话就往后挪动
            while(j > 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            // 将牌插入到位置记录位置的后一位
            arr[j+1] = key;
        }
    }
    public static void quickSort(int[] arr, int low, int high) {
        int l = low;
        int h = high-1;
        if(l>=h) {
            return;
        }
        int key = arr[l];
        while(l<h) {
            while(l<h && arr[h] >= key) {
                h--;
            }
            if(l<h) {
                arr[l++] = arr[h];
            }
            while(l<h && arr[l] < key) {
                l++;
            }
            if(l<h) {
                arr[h--] = arr[l];
            }
        }
        arr[l] = key;
        quickSort(arr, low, l);
        quickSort(arr, h+1, high);
        
    }
    public static void main(String[] args) {
        int[] a = {6,2,4,5,3,2,66,33,22,1,6,7};
//        insertionSort(a);
        quickSort(a, 0, a.length);
        System.out.println(Arrays.toString(a));
    }
}
