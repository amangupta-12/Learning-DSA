class Solution {
    public boolean carPooling(int[][] nums, int capacity) {
        
         TreeMap<Integer,Integer> map = new TreeMap<>();
            int cap = 0;
         for(int[] num : nums){
            map.put(num[1],map.getOrDefault(num[1],0)+num[0]);
            map.put(num[2],map.getOrDefault(num[2],0)-num[0]);
         }

         for(int k : map.values()){
            cap += k;
            if(cap > capacity){
                return false;
            }
         }

         return true;
    }
}