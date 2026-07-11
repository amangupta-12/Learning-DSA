class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) {
            return ans;
        }

        int[] freqP = new int[26];
        int[] freqW = new int[26];

        int k = p.length();

        for (int i = 0; i < k; i++) {
            freqP[p.charAt(i) - 'a']++;
            freqW[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freqP, freqW)) {
            ans.add(0);
        }

        for (int i = k; i < s.length(); i++) {

            freqW[s.charAt(i - k) - 'a']--; // remove left character
            freqW[s.charAt(i) - 'a']++;     // add right character

            if (Arrays.equals(freqP, freqW)) {
                ans.add(i - k + 1);
            }
        }

        return ans;
    }
}