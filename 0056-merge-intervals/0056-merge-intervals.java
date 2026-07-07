class Solution {
    public int[][] merge(int[][] a) {
         List<int[]> list = new ArrayList<>();

         Arrays.sort(a, (b,c)->Integer.compare(b[0],c[0]));
          int s = a[0][0];
          int e = a[0][1];
          for(int i=1;i<a.length;i++){
            if(a[i][0] <= e){
            
                e = Math.max(a[i][1],e);
            }else{
                 list.add(new int[]{s,e});
                s =  a[i][0];
                e =  a[i][1];
            
            }
          }
           list.add( new int[]{s,e});
         
         return list.toArray(new int[list.size()][]);
    }
}