package educativity.algojava.search.excersise.search;

public class SearchInMatrix {
    public static Object findKey(int[][] matrix, int numberOfRows, int numberOfColumns, int target) {
        for (int i = 0; i < numberOfRows; i++) {
            if(matrix[i][0] <= target && matrix[i][numberOfColumns-1] >= target){
                for (int j = 0; j < numberOfColumns; j++) {
                    if(matrix[i][j] == target){
                        return Boolean.TRUE;
                    }
                }
            }
        }
        // write your code here
        return Boolean.FALSE;
    }
}
