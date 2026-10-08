class Solution {
    public int[][] intervalIntersection(int[][] first, int[][] sec) {
        List<int[]> list = new ArrayList<>();

        int i=0;
        int j =0;
        while(i < first.length && j < sec.length){
            int s1 = first[i][0];
            int e1 = first[i][1];
            int s2 = sec[j][0];
            int e2 = sec[j][1];

            if(s2 <= e1 && s1 <= e2){
                int st = Math.max(s1,s2);
                int end = Math.min(e1,e2);
                list.add(new int[]{st,end});
            }
            if(e1 < e2){
                i++;
            }else{
                j++;
            }
        }
    int[][] ans = new int[list.size()][2];
       for(int k=0;k<list.size();k++){
        ans[k] = list.get(k);
       }

       return ans;
    }
}