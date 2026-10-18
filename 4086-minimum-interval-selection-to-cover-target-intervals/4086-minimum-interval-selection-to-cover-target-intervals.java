class Solution {
    public int minSelection(int[][] avl, int[][] tar) {
        Arrays.sort(avl , (a,b)-> Integer.compare(a[0],b[0]));
        Arrays.sort(tar, (a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> list = new ArrayList<>();

        int i = 0;
        int count = 0;
        int reach = -1;
        int best = -1;
       for(int j = 0;j<tar.length;j++){
        int s = tar[j][0];
        int e = tar[j][1];
        while(reach < e){
            int limit = Math.max(reach , s);
            while(i < avl.length && avl[i][0] <= limit){
                best = Math.max(best , avl[i][1]);
                i++;
            }
            if (best<=reach || best< s) return -1;
                reach=best;
                count++;
        } 
       }
       return count;
    }
}