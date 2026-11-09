class Solution {
    public boolean canPlaceFlowers(int[] f, int n) {
        int len = f.length;
        int i = 0;
        if(len == 1 && f[0] == 0  && n <= 1) return true;
        while( i < len-1  && n > 0){
    
            if(i == 0 && f[i] == 0 && f[i+1] == 0){
                f[i] = 1;
                n--;
                i+=2;
            }else if(i > 0 && f[i] == 0 && f[i-1] == 0 && f[i+1] == 0){
                f[i] = 1;
                n--;
                i+=2;
            }else{
                i++;
            }
        }
        if(len > 2){
        if(f[len-3] == 1 && f[len-2] == 0 && f[len-1] == 0){
            n--;
        }
        }
        return (n <= 0);
    }
}