package leetcode.explore.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTreangle {
    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex==0){
            return new ArrayList<>(Arrays.asList(1));
        }
        if (rowIndex==1){
            return new ArrayList<>(Arrays.asList(1, 1));
        }
        List<Integer> start = new ArrayList<>(Arrays.asList(1, 1));
        return makePTL(start, 1, rowIndex);

    }

    private static List<Integer> makePTL(List<Integer> list, int currIndex, int endIndex){
        if(currIndex < endIndex){
            List<Integer> nexList = new ArrayList<>();
            nexList.add(1);
            for (int i = 0; i < list.size()-1; i++) {
                nexList.add(list.get(i) + list.get(i+1));
            }
            nexList.add(1);
            currIndex++;
            return makePTL(nexList, currIndex, endIndex);
        }
        return list;
    }

    public static void main(String[] args) {
        for(Integer i : PascalTreangle.getRow(2)){
            System.out.print( i + " : ");
        }
    }
}
