package leetcode.explore.array.explore.inplaceoper;

public class ReplaceElement {
    public static int[] replaceElements(int[] arr) {
        if(arr.length==1){
            arr[0] = -1;
            return arr;
        }
        if(arr.length==2){
            arr[0] = arr[1];
            arr[1] = -1;
            return arr;
        }
        int rigthMax = arr[arr.length-1];
        int tmpVal = 0;
        arr[arr.length-1] = -1;
        for (int i = arr.length-2; i >-1 ; i--) {
            tmpVal = rigthMax;
            rigthMax = Math.max(arr[i], rigthMax);
            arr[i] = tmpVal;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = new int[]{17,18,5,4,6,1};
        for( int elem : ReplaceElement.replaceElements(input) ){
            System.out.print(elem + " : ");
        }
    }
}
