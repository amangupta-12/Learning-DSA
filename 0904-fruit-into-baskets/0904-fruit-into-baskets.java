class Solution {
    public int totalFruit(int[] nums) {

    HashMap<Integer,Integer> map = new HashMap<>();
    int n = nums.length;
    int i=0,j=0;
    int maxFruits = 0;

       while(i<n && j<n){    
        if(map.size()>2){
            map.put(nums[i],map.get(nums[i])-1);
            if(map.get(nums[i])==0) map.remove(nums[i]);
            i++;
        }else{
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(map.size()<=2){
            maxFruits = Math.max(maxFruits,j-i+1);
            }
            j++;
        }
    }

    return maxFruits;
    }
}