class Solution {
    public int[] numberOfPairs(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int x : nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int pair  = 0 , single = 0;
        for(int x : map.keySet()){
            if(map.get(x)%2==1){
                single++;
            }
            pair+= (map.get(x)/2);
        }
        return new int[] {pair,single};
    }
}