class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        if((num * 9) < sum ) return "";
        while(num > 0){
            if(sum > 9){
                sb.append(9);
                sum -= 9;
            }else{
                sb.append(sum);
                sum = 0;
            }
        num--;
        }
        return sb.toString();
    }
}