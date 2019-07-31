package leetcode;

public class Palindrome {

    public boolean isPalindrome(int x) {
        int t = x;
        int reverseNum = 0;
        if(x < 0) {
            return false;
        }
        while(t != 0) {
            int l = t % 10;
            reverseNum = reverseNum * 10+ l ;
            t = t/10;
        }
        if(x == reverseNum) {
            return true;
        }
        return false;
        
    }
    
    public static void main(String[] args) {
        new Palindrome().isPalindrome(-121);
    }

}
