class Solution {
    private void solve(int idx , int n , List<String> result,StringBuilder curr,int countclose ,int countopen){
        if(curr.length() == 2*n){
            result.add(curr.toString());
            return;
        }
    
        if(countopen < n ){
            curr.append('(');
            solve(idx+1,n,result,curr,countclose,countopen+1);
            curr.deleteCharAt(curr.length()-1);
        }
            if(countclose < countopen){
            curr.append(')');
            solve(idx+1,n,result,curr,countclose+1,countopen);
            curr.deleteCharAt(curr.length()-1);
            }


    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
       
        solve(0,n,result,sb,0,0);
        return result;
    }
}