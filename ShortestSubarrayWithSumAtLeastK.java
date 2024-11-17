class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        long prefix[] = new long[n+1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }

        for(int j=0;j<=n;j++){

            while(!deque.isEmpty() && (prefix[j]-prefix[deque.peekFirst()] >= k)){
                int i = deque.pollFirst();
                result = Math.min(result,j-i);
            }
            while(!deque.isEmpty() && (prefix[j] <= prefix[deque.peekLast()])){
                deque.pollLast();
            }
            deque.offerLast(j);
        }
return result == Integer.MAX_VALUE?-1:result;
        
    }
}
