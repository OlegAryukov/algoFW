package leetcode.explore.greed.easy.medium;

import java.util.ArrayList;
import java.util.List;

public class PeopleGroup {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        int length = groupSizes.length;
        for (int i = 0; i < length; i++) {
            if(groupSizes[i] > 1){
                makeNewGroup(result,groupSizes, i, groupSizes[i]);
            }
        }
        return null;
    }

    private List<Integer> makeNewGroup(List<List<Integer>> res, int[] groupSize, int i, int groupS){
        List<Integer> group = new ArrayList<>();
        for (int j = i; j < groupSize.length; j++) {
            if(groupSize[j] == groupS){
                group.add(j);
            }
        }
        return null;
    }
}
