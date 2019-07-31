package leetcode;

import java.util.LinkedList;
import java.util.List;

public class linke {
    public static void main(String[] args) {
        List<List<Integer>> r = new LinkedList<>();
        LinkedList<List<Integer>> r1 = new LinkedList<>();
        r.stream().forEach((l->r1.add(0, l)));
    }
}
