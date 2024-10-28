class LongestSquareStreak {
    public int longestSquareStreak(int[] nums) {
      Map<Integer,Integer> map = new HashMap<>();
      Arrays.sort(nums);
      int longStreak =0;
      for(int i=0;i<nums.length;i++){
        int mathsqrt =(int) Math.sqrt(nums[i]);
       if(mathsqrt * mathsqrt==nums[i] && map.containsKey(mathsqrt)){
        map.put(nums[i],map.get(mathsqrt)+1);
       }
       else{
        map.put(nums[i],1);
       }
      }  
      for(int v: map.values()){
        longStreak = Math.max(longStreak,v);
      }
    return longStreak==1?-1:longStreak;
    }
}
