class Solution {

    public boolean checkInclusion(String p, String s) {
        int[] P = new int[26];
        int[] T = new int[26];
        if (s.length() < p.length()) return false;
        for (int i = 0; i < p.length(); i++) {
            P[p.charAt(i) - 'a']++;
            T[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(P, T)) {
            return true;
        }

        int i = 0;
        for (int j = p.length(); j < s.length(); j++) {
            T[s.charAt(i) - 'a']--;
            i++;
            T[s.charAt(j) - 'a']++;

            if (Arrays.equals(P, T)) {
                return true;
            }
        }

        return false;
    }
}