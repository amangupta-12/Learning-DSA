class Solution {
    boolean solve(int n,HashMap<Integer,Integer> map){
        if(n == 1){
            return true;
        }
        if(map.containsKey(n)){
            return false;
        }else{
            map.put(n,1);
        }
        int sum = 0;
        while(n!=0){
            sum += (n%10)*(n%10);
            n = n/10;
        }
        return solve(sum,map);
    }
    public boolean isHappy(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return solve(n,map);
    }
}