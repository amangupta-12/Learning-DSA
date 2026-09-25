class Solution {
//     String solve(int n){
//         if(n == 1){
//             return "1";
//         }
//         String prev = solve(n-1);
//         int count = 1;
//         StringBuilder sb = new StringBuilder();
//         for(int i=1;i<prev.length();i++){
//             if(prev.charAt(i) == prev.charAt(i-1)){
//                 count++;
//             }else{
//                 sb.append(count);
//                 sb.append(prev.charAt(i-1));
//                 count = 1;
//             }
//         }
//         sb.append(count);
//         sb.append(prev.charAt(prev.length()-1));

//         return sb.toString();
//     }
//     public String countAndSay(int n) {
//         return solve(n);
//     }
// }

public String countAndSay(int n) {
    String prev = "1";
    for(int j=0;j<n;j++){
         int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<prev.length();i++){
            if(prev.charAt(i) == prev.charAt(i-1)){
                count++;
            }else{
                sb.append(count);
                sb.append(prev.charAt(i-1));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(prev.charAt(prev.length()-1));
         prev = (j == n-1) ? prev : sb.toString();
    }

    return prev;
}
}

       