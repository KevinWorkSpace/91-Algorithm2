package Stack.lecture;

public class UpdateMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i=0; i<res.length; i++) {
            for (int j=0; j<res[0].length; j++) {
                res[i][j] = Integer.MAX_VALUE;
            }
        }
        boolean[][] visit = new boolean[res.length][res[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                helper(matrix, res, visit, i, j);
            }
        }
        return res;
    }

    public int helper(int[][] matrix, int[][] res, boolean[][] visit, int i, int j) {
        if (i == 2 && j == 1) {
            System.out.println();
        }
        if (i < 0 || i == matrix.length || j < 0 || j == matrix[0].length) return Integer.MAX_VALUE;
        if (visit[i][j] == true) return res[i][j];
        visit[i][j] = true;
        if (matrix[i][j] == 0) {
            res[i][j] = 0;
            return res[i][j];
        }
        int n1 = helper(matrix, res, visit, i+1, j);
        int n2 = helper(matrix, res, visit,i-1, j);
        int n3 = helper(matrix, res, visit, i, j+1);
        int n4 = helper(matrix, res, visit, i, j-1);
        int num =  Math.min(Math.min(n1, n2), Math.min(n3, n4));
        res[i][j] = num + 1;
        return num + 1;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {0, 0, 0},
//                {0, 1, 0},
//                {1, 1, 1}
//        };
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        UpdateMatrix updateMatrix = new UpdateMatrix();
        updateMatrix.updateMatrix(matrix);
    }

}
