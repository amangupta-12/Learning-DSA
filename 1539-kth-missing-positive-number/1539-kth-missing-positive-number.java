class Solution {
    public int findKthPositive(int[] arr, int k) {
     int count = 0;
     int i=1;
     int j=0;
     while(j<arr.length){
        if(arr[j]==i){
            j++;
        }else{
            count++;
        }
        if(count == k){
            return i;
        }
        i++;
     }

     return arr[arr.length-1]+(k-count);
    }
}









