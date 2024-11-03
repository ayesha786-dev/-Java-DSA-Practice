class RotateString {
    public boolean rotateString(String s, String goal) {
       char c[]= s.toCharArray();
       char c1[]= goal.toCharArray();
      
      if(c1.length==c.length){
        for(int i=0;i<c.length;i++){
            String rotated = s.substring(i) + s.substring(0, i);
            if (rotated.equals(goal)) {
                return true;
            }
        }
      }
      return false;
    }
}
