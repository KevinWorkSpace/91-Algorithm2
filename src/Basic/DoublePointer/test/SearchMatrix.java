package Basic.DoublePointer.test;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int up = 0;
        int down = matrix.length - 1;
        while (up < down) {
            int mid = up + (down - up + 1) / 2;
            if (matrix[mid][0] <= target) {
                up = mid;
            }
            else {
                down = mid - 1;
            }
        }
        int left = 0;
        int right = matrix[up].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[up][mid] < target) {
                left = mid + 1;
            }
            else if (matrix[up][mid] > target) {
                right = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1}};
        int target = 1;
        SearchMatrix searchMatrix = new SearchMatrix();
        boolean res = searchMatrix.searchMatrix(nums, target);
        System.out.println(res);
    }
}
