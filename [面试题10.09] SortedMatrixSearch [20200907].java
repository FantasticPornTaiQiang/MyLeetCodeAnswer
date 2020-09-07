import javax.management.modelmbean.InvalidTargetObjectTypeException;

public class SortedMatrixSearch {

    public static void main(String[] args) {
        int[][] matrix = {{-1,3}};
        System.out.println(searchMatrix(matrix, 3));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int maxRow = matrix.length;
        if(maxRow == 0 ||matrix[0].length == 0 || target < matrix[0][0] || target > matrix[maxRow - 1][matrix[0].length - 1])
            return false;
        int maxCol = matrix[0].length;

        int row = 0, col = maxCol - 1;
        while(row < maxRow && col >= 0) {
            if(matrix[row][col] > target) {
                col --;
            } else if (matrix[row][col] < target) {
                row ++;
            } else if (matrix[row][col] == target) {
                return true;
            }
        }
        return false;
    }
}
