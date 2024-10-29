import java.util.Arrays;

class MaximumMoves {
    int m, n;
    int dp[][];
    int grid[][];
    
    public int memSolve(int i, int j) {
        // If this cell has already been computed, return the stored result
        if (dp[i][j] != -1) return dp[i][j];
        
        int res = 0;

        // Move up-right
        if (i - 1 >= 0 && j + 1 < n && grid[i - 1][j + 1] > grid[i][j]) {
            res = Math.max(res, 1 + memSolve(i - 1, j + 1));
        }
        // Move right
        if (j + 1 < n && grid[i][j + 1] > grid[i][j]) {
            res = Math.max(res, 1 + memSolve(i, j + 1));
        }
        // Move down-right
        if (i + 1 < m && j + 1 < n && grid[i + 1][j + 1] > grid[i][j]) {
            res = Math.max(res, 1 + memSolve(i + 1, j + 1));
        }

        dp[i][j] = res;
        return res;
    }
    
    public int maxMoves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        dp = new int[m][n];

        // Initialize dp array with -1 to indicate unvisited cells
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        int res = 0;
        // Start from every cell in the first column
        for (int i = 0; i < m; i++) {
            res = Math.max(memSolve(i, 0), res);
        }
        
        return res;
    }
}
