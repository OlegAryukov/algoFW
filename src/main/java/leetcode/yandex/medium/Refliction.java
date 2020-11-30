package leetcode.yandex.medium;

import java.util.*;

public class Refliction {
    public boolean isReflected(int[][] points) {
        Map<Integer, Set<Integer>> m = new HashMap();
        for (int[] p : points) {
            m.putIfAbsent(p[1], new HashSet());
            m.get(p[1]).add(p[0]);
        }
        Integer mid = null;
        for (Set<Integer> s : m.values()) {
            List<Integer> l = new ArrayList(s);
            Collections.sort(l);
            int left = 0, right = l.size()-1;
            while (left <= right) {
                int newmid = l.get(left++) + l.get(right--);
                if (mid == null) {
                    mid = newmid;
                } else {
                    if (mid != newmid) return false;
                }
            }
        }
        return true;
    }
}
