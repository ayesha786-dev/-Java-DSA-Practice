class MountainRemoval {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return n;  // Not enough elements to form a mountain array
        }

        // Step 1: Find the longest increasing subsequence (LIS)
        int[] lis = new int[n];
        for (int i = 0; i < n; i++) {
            lis[i] = 1; // Each element is an LIS of at least length 1
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Step 2: Find the longest decreasing subsequence (LDS)
        int[] lds = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1; // Each element is an LDS of at least length 1
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Step 3: Determine the minimum number of elements to remove
        int minRemovals = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) { // Peak index should be between 0 and n-1
            if (lis[i] > 1 && lds[i] > 1) { // Valid peak
                int removals = n - (lis[i] + lds[i] - 1);
                minRemovals = Math.min(minRemovals, removals);
            }
        }

        return minRemovals == Integer.MAX_VALUE ? n : minRemovals; 
    }
}
