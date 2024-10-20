class ParseABooleanExpression {
    public char evaluateSubExpr(char op,List<Character> values){
        if(op=='!'){
            return values.get(0)=='t'?'f':'t';
        }else if(op=='&'){
            for(Character c:values){
                if(c=='f')
                return 'f';
            }
            return 't';
        }
        else{
            for(Character c:values){
                if(c=='t')
                return 't';
            }
            return 'f';
        }
        //return 't';
    }
    public boolean parseBoolExpr(String expression) {
        int len=expression.length();
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<len;i++){
            if(expression.charAt(i)==',')
            continue;

            if(expression.charAt(i)==')'){
                List<Character> values = new ArrayList<Character>();
                while(st.peek()!='('){
                    values.add(st.pop());
                }
                st.pop();
                char op = st.pop();
                st.push(evaluateSubExpr(op, values));
            }
            else{
                st.push(expression.charAt(i));
            }
        }
        return st.peek()=='f'?false:true;
    }
}
