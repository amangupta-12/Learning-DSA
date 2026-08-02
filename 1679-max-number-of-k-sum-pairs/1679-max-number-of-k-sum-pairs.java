class Solution {
    public int maxOperations(int[] nums, int k) {
       
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int x : nums){
            map.put(x,map.getOrDefault(x,0)+1);
           
        }
        int ans = 0;
        for(int x : map.keySet()){
            int y  =  k - x;
            if(map.containsKey(y)){
                if(x<y){
                    ans+=Math.min(map.get(x),map.get(y));
                }else if(x==y){
                    ans+=(map.get(x))/2;
                }
            }
        }
        return ans;
    }
}