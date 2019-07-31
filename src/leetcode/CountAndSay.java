package leetcode;

public class CountAndSay {
    public String countAndSay(int n) {
        return countAndSay("1", 1, n);
     }
     String countAndSay(String s, int depth, int n){
         if(depth == n){
             return s;
         }
         String ans = "";
         int cnt = 1;
         for(int i = 0; i < s.length(); i++){
             if(i < s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                 cnt++;
             }else{
                 ans += (char)(cnt + '0');
                 System.out.println(ans);
                 ans += s.charAt(i);
                 cnt = 1;
             }
         }
         return countAndSay(ans, depth+1, n);
     }
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(3));

    }

}
