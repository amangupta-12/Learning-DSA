class Solution {
    public int countDays(int days, int[][] m) {
        Arrays.sort(m, (a, b) -> Integer.compare(a[0], b[0]));
        int s1 = m[0][0];
        int e1 = m[0][1];
        int idle = 0;
        idle += s1-1;
        for (int i = 1; i < m.length; i++) {
            int s2 = m[i][0];
            int e2 = m[i][1];

            if(s1 > e2 || s2 > e1){
                idle += (Math.abs(Math.min(e1,e2) - Math.max(s1,s2)) -1);
                s1 = s2;
             e1 = e2;
            }else{
                s1 = Math.min(s1,s2);
                e1 = Math.max(e1,e2);
            }
            
        }
        idle += days - e1;

        return idle;
    }
}