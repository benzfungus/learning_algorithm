package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left; i <= right; i++){
//            String s = i+"";
//            char[] c = s.toCharArray();
//            boolean isPass = true;
//            int count = 0;
//            for(char c1 : c){
//                
//                int p = Character.getNumericValue(c1);
//                if(p == 0) {
//                    break;
//                }
//                if(i % p == 0) {
//                    count ++;
//                }               
//            }
//            if(count == c.length) {
//                list.add(i);
//            }
//            
//        }
//
//        return list;
            
            if(isSelfDivide(i)) {
                list.add(i);
            }
           
        }
        list.stream().forEach(System.out::println);
        return list;
       
    }
    
    private boolean isSelfDivide(int i) {
        int t = i;
        while (t != 0) {
            int l = t % 10;
            if(l == 0 || i % l != 0) {
                return false;
            }
            t = t / 10;
            
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new SelfDividingNumbers().selfDividingNumbers(1,22);
    }

}
