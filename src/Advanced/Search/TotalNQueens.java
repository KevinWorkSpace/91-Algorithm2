package Advanced.Search;

public class TotalNQueens {

    int cnt = 0;
    int[] res = null;
    int n = 0;

    public int totalNQueens(int n) {
        res = new int[n];
        this.n = n;
        calQueue(0);
        return cnt;
    }

    public void calQueue(int row) {
        if (row == n) {
            cnt ++;
            return;
        }
        for (int col=0; col<n; col++) {
            if (isOk(row, col)) {
                res[row] = col;
                calQueue(row + 1);
            }
        }
    }

    public boolean isOk(int row, int col) {
        int leftup = col - 1;
        int rightup = col + 1;
        for (int i=row-1; i>=0; i--) {
            if (res[i] == col) return false;
            if (leftup >= 0 && res[i] == leftup) return false;
            if (rightup < n && res[i] == rightup) return false;
            leftup --;
            rightup ++;
        }
        return true;
    }

}
