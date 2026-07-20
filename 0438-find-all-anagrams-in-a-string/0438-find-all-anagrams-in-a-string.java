class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int[] pfreq =  new int[26];
        int[] sfreq =  new int[26];

        for(int i=0;i<p.length();i++){
            pfreq[p.charAt(i)-'a']++;
        }

        int i = 0;
        int n = s.length();
        int count = 0;
        for(int j=0;j<n;j++){
          sfreq[s.charAt(j)-'a']++;
          count++;
          while(count > p.length()){
            sfreq[s.charAt(i)-'a']--;
            i++;
            count--;
          }
          if(count == p.length()){
            if(Arrays.equals(pfreq,sfreq)){
                list.add(i);
            }
          }
        }


        return list;
    }
}
