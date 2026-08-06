class Solution {

    private boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;j--;
            }else{
                return false;
            }
        }
        return true;
    }

    private void solve(int idx , String s, List<List<String>> result,ArrayList<String> curr){
        if(idx == s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }
            for(int i=idx;i<s.length();i++){
                if(isPalindrome(s.substring(idx,i+1))){
                    curr.add(s.substring(idx,i+1));
                    solve(i+1,s,result,curr);
                    curr.remove(curr.size()-1);
                }
            }

    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> curr =  new ArrayList<>();

        solve(0,s,result,curr);

        return result;
    }
}