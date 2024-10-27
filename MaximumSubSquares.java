import java.util.*;

class MaximumSubSquares {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0; // Handle edge cases
        }

        int n = matrix.length;         // Number of rows
        int m = matrix[0].length;      // Number of columns
        int[][] dp = new int[n][m];   // DP array

        // Initialize the first row
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];  // Copy values for the first row
        }

        // Initialize the first column
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];  // Copy values for the first column
        }

        // Fill the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }

        // Calculate the sum of all square counts
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += dp[i][j];
            }
        }
        return sum; // Return the total count
    }
}
