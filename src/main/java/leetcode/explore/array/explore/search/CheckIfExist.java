package leetcode.explore.array.explore.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckIfExist {
    public boolean checkIfExist(int[] arr) {
        if(arr.length==1){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i] * 2)){
                return true;
            }
            if(arr[i]%2==0 && map.containsKey(arr[i]/2)){
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }

    public static boolean checkIfExist2(int[] arr) {
        Arrays.sort(arr);
        int newLength = Math.max(Math.abs(arr[0]), Math.abs(arr[arr.length-1]));
        int[] temp = new int[(newLength+1) * 2];
        for (int i = 0; i < arr.length; i++) {
            if(temp[Math.abs(arr[i]*2)]==arr[i]*2){
                return true;
            }
            if (arr[i]%2==0 && temp[Math.abs(arr[i]/2)]==arr[i]/2){
                return true;
            }
            temp[Math.abs(arr[i])] = arr[i];
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-2,0,10,-19,4,6,-8};
        System.out.println(CheckIfExist.checkIfExist2(input));
    }
}