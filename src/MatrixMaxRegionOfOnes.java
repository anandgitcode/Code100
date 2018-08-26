/**
 * Find maximum region of 1's in a 2D matrix of 0's and 1's
 */
public class MatrixMaxRegionOfOnes {

    /**
     * Recursive DFS function
     * @param matrix - 2D array of 1's and 0's
     * @param row - current cell's row
     * @param col - current cell's column
     * @return - size of cluster of 1's from this cell
     */
    public int getRegionSize(int[][] matrix, int row, int col) {
        // boundary checks
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
            return 0;
        }

        // ignore/continue if current cell is '0'
        if (matrix[row][col] == 0) {
            return 0;
        }

        // sicne the current cell is not '0' from above, it is '1'
        // mark the current cell '0' mentioning it's visited
        // and, count 1 for size
        matrix[row][col] = 0;
        int size = 1;

        // since we ahve to check all adjacent cells, we will cover
        // previous, current & next rows and cols
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                // recurse
                size += getRegionSize(matrix, r, c);
            }
        }

        return size;
    }

    /**
     *
     * @param matrix - 2D array of 1's and 0's
     * @return - maximum size of 1's in the matrix
     */
    public int maxRegionSize(int[][] matrix) {
        int maxSize = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int size = getRegionSize(matrix, row, col);
                maxSize = Math.max(size, maxSize);
            }
        }
        return maxSize;
    }

    // Test client
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 1, 0, 1, 1},
            {1, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0}
        };
        MatrixMaxRegionOfOnes region = new MatrixMaxRegionOfOnes();
        System.out.println(region.maxRegionSize(matrix));
    }

}