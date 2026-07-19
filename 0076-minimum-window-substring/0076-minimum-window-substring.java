class Solution {
    public String minWindow(String s1, String t1) {
        HashMap<Character,Integer> map = new HashMap<>();
      
         int n =  s1.length();

        for(int i=0;i<t1.length();i++){
            map.put(t1.charAt(i),map.getOrDefault(t1.charAt(i),0)+1);
        }

        int i=0,j=0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        String ans = "";
        while(i<n && j<n){
            if(map.containsKey(s1.charAt(j))){
                if(map.get(s1.charAt(j))>0){
                    count++;
                }
                map.put(s1.charAt(j),map.get(s1.charAt(j))-1);
            }

            while(count >= t1.length()){
                if(j-i+1 < min){
                    ans = s1.substring(i,j+1);
                    min =  j-i+1;
                }
                if(map.containsKey(s1.charAt(i))){
                    if(map.get(s1.charAt(i))>=0){
                        count--;
                    }
                    map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
                }
                i++;
            }

            j++;

            
        }


        return ans;
    }
}

   
