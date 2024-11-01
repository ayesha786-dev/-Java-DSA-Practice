class FancyString {
    public String makeFancyString(String s) {
        int n=s.length();
        StringBuilder sb = new StringBuilder();
        if(n < 3){
            return s;
        }
        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            if(i+1<n && i+2<n && curr==s.charAt(i+1) && curr==s.charAt(i+2)){
                continue;
            }
            else{
              sb.append(curr);
            }
        }
        return sb.toString();
    }
}
