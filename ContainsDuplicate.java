class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
       Map<Integer,Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(i->i,Collectors.counting()));

       for(Map.Entry me:map.entrySet()){
        if((Long)me.getValue()>1){
            return true;
        }
       }
    return false;
}
}
