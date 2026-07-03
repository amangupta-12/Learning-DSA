class Solution {

    int[] pre;

        int total;
    public Solution(int[] w) {
    pre = new int[w.length];
        pre[0] = w[0];
        for(int i=1;i<w.length;i++){
            pre[i] = pre[i-1]+w[i];
            }
            total = pre[w.length-1];
        }
        
    
    
    public int pickIndex() {
            int rand = (int)(Math.random()*total)+1;
        int left = 0;
        int right = pre.length-1;
        while(left<right){
            int mid = left+(right-left)/2;

            if(pre[mid]>=rand){
                right = mid;
            }else{
                left = mid +1;
            }
        }
        return left;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */