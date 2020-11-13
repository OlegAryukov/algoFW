package educativity.algojava.search.excersise.dynamic;

import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindow {
    public static int totalFruit(int[] tree) {
        if (tree.length == 1) {
            return 1;
        }
        if (tree.length == 2) {
            return 2;
        }
        int i = tree[0];
        int j = tree[1];
        int iCount = 1;
        int jCount = 1;
        int start = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int k = 1; k < tree.length; k++) {
            if (tree[k] == tree[k - 1]) {
                iCount++;
                queue.add(iCount);
                if(k==tree.length-1){
                    int res = 0;
                    while (!queue.isEmpty()){
                        res = queue.poll();
                    }
                    return res;
                }
                continue;
            }
            j = tree[k];
            //jCount++;
            start = k;
            queue.add(iCount + jCount);
            break;
        }
        for (int k = start+1; k < tree.length; k++) {
            if ((tree[k] == i || tree[k] == j) && (tree[k - 1] == i || tree[k - 1] == j)) {
                if (tree[k] == i) {
                    iCount++;
                }
                if (tree[k] == j) {
                    jCount++;
                }
                queue.add(iCount + jCount);
                continue;
            } else {
                if(tree[k-1]==i){
                    iCount=1;
                    i = tree[k-1];
                }
                if (tree[k]!=j){
                    jCount=1;
                    j = tree[k];
                }

                queue.add(iCount+jCount);
            }

        }
        int res = 0;
        while (!queue.isEmpty()){
            res = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(SlidingWindow.totalFruit(new int[]{0, 1, 6, 6, 4, 4, 6}));
        System.out.println(SlidingWindow.totalFruit(new int[]{3, 3, 3, 3, 3}));
        System.out.println(SlidingWindow.totalFruit(new int[]{1, 0, 3, 4, 3}));
        System.out.println(SlidingWindow.totalFruit(new int[]{0, 0, 1, 1}));
        System.out.println(SlidingWindow.totalFruit(new int[]{1, 2, 1}));
        System.out.println(SlidingWindow.totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(SlidingWindow.totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(SlidingWindow.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }
}
