class Solution {
    void reverse(int i,int j,int[] a){
        while(i<=j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        i++;j--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        reverse(0,n-1,nums);
        reverse(0,(k%n)-1,nums);
        reverse((k%n),n-1,nums);

    
    }
}