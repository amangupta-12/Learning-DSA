class Solution {
   public int change(int amount, int[] coins) {
    // int[][] dp = new int[coins.length][amount+1];
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];

        for(int target=0;target<=amount;target++){
            if(target%coins[0] == 0){
                prev[target] = 1;
            }else{
                prev[target] = 0;
            }
        }

        for(int i=1;i<coins.length;i++){
            for(int target = 0;target<=amount;target++){
                int take = 0;
                if(target-coins[i]>=0){
                    take = curr[target-coins[i]];
                }
                int skip = prev[target];

                curr[target] = take + skip;
            }
            prev = curr;
        }
        return prev[amount];
    }
}