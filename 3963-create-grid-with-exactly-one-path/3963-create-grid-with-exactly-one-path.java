class Solution {
    public String[] createGrid(int m, int n) {
        
        String[] str = new String[m];

        if(m == 1){
         StringBuilder sb = new StringBuilder();
            while(n != 0){
                sb.append('.');
                n--;
            }
            return new String[]{sb.toString()};
        }else if(n == 1){
            int i = 0;
            while(m != 0){
           str[i] = ".";
           i++;
           m--; 
            }
            return str;
        }
        int dumN = m-1;
         int i = 0;
        while(dumN != 0){
        StringBuilder sb = new StringBuilder();
            int val = n;
            sb.append('.');
            val--;
            while(val != 0){
                sb.append('#');
                val--;
            }
            str[i] = sb.toString();
            i++;
            dumN--;
        }
        StringBuilder sb = new StringBuilder();
        while(n != 0){
                sb.append('.');
                n--;
            }
            str[i] = sb.toString();

        return str;
    }
}