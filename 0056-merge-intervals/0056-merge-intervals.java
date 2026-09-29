class Solution {
    public int[][] merge(int[][] a) {
        Arrays.sort(a , (p,q)-> Integer.compare(p[0],q[0]));
       ArrayList<int[]> list = new ArrayList<>();
       list.add(a[0]);

       for(int i=1;i<a.length;i++){
        int[] last = list.get(list.size()-1);
        int[] curr = a[i];
        if(last[1] >= curr[0]){
            last[1] = Math.max(last[1],curr[1]);
        }else{
            list.add(curr);
        }
       }

       int[][] ans = new int[list.size()][2];

       for(int i=0;i<list.size();i++){
        ans[i] = list.get(i);
       }

       return ans;
    }
}