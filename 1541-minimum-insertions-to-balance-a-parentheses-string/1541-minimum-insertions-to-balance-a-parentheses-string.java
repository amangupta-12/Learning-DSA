class Solution {
    public int minInsertions(String s) {
        int countRight = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (countRight < 0) {
                    int r = (-countRight);
                    ans += (r % 2 == 1) ? (r / 2) + 2 : r / 2;
                    countRight = 0;
                }
                if (countRight % 2 == 1) {
                    ans++;
                    countRight--;
                }
                countRight += 2;
            } else {
                countRight--;
            }
        }
        if (countRight < 0) {
            int r = (-countRight);
            ans += (r % 2 == 1) ? (r / 2) + 2 : r / 2;
        } else {
            ans += countRight;
        }

        return ans;
    }
}