package leetcode.explore.array;

public class DiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {
        int counter = 0;
        int[] res = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < counter; i++) {

            for (int j = 0; j < counter; j++){
                res[counter] = matrix[i][j];
                counter++;
            }
        }
        return null;
    }
}
