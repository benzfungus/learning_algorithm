package leetcode;

import java.util.HashMap;
import java.util.Map;

class UniqueMorse {
    public int uniqueMorseRepresentations(String[] words) {
        if(words.length <= 1){
            return words.length;
        }
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Character zimu = 97;
        Map<Character, String> mos = new HashMap<>();
        Map<String, Integer> mx = new HashMap<>();
        for(String a : arr){
            mos.put(zimu++, a);
        }
        mos.keySet().stream().forEach(System.out::println);
        for(String w : words){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < w.length(); i++){
                Character key = w.charAt(i);
                String value = mos.get(key);
               
                sb.append(value);
            }
            String s = sb.toString();
            System.out.println(s);
            if(mx.containsKey(s)){
                mx.put(s, mx.get(s)+1);
            }else{
            mx.put(s, 1);
            }
        }
        mx.values().stream().forEach((a)->System.out.println(a));
        return mx.size();
        
        
    }
    public static void main(String[] args) {
        UniqueMorse s = new UniqueMorse();
        s.uniqueMorseRepresentations(new String[] {"rwjje","aittjje","auyyn","lqtktn","lmjwn"});
    }
}