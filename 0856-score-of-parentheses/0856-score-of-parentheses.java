class Solution {
       
    public int scoreOfParentheses(String s) {
        
        ArrayList<Integer> store =  new ArrayList<>();
        int score = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                store.add(score);
                score = 0;
            }else{
                if(s.charAt(i-1) == '('){
                    score = store.get(store.size()-1) + 1; 
                }else{
                    score = store.get(store.size()-1) + (2*score);
                }
                store.remove(store.size()-1);
            }
            
        }

        return score;
    }
}