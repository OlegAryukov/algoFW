package leetcode.explore.array.explore.inplaceoper;

public class SortEvenAndNotEven {
    public int[] sortArrayByParity(int[] A) {
        if(A.length ==1){
            return A;
        }
        int[] res = new int[A.length];
        int k = 0;
        int j=A.length-1;
        for (int i = 0; i <=j; i++) {
            if(A[i]%2==0){
                res[k] = A[i];
                k++;
                continue;
            }
            A[j] = A[i];
            j--;
        }
        return res;
    }
}
