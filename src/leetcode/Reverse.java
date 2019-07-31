package leetcode;

public class Reverse {
    public int reverse(int x) {
        int t = x;
        long reverseNum = 0;
        
        while(t != 0) {
            int l = t % 10;
            reverseNum = reverseNum * 10+ l ;
            t = t/10;
        }
        if(reverseNum >= Integer.MAX_VALUE || reverseNum <= Integer.MIN_VALUE){
            return 0;
        }
        
        return (int)reverseNum;
    }
    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(1534236469));

    }

}
