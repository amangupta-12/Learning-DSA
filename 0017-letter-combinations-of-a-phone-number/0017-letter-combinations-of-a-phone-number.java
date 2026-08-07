class Solution {

    private void solve(int idx, String digits,
                       List<String> result,
                       StringBuilder curr,
                       HashMap<String,String> map) {

        if(idx == digits.length()) {
            result.add(curr.toString());
            return;
        }

        String ch = map.get(String.valueOf(digits.charAt(idx)));

        char[] s = ch.toCharArray();

        for(int i = 0; i < s.length; i++) {

            curr.append(s[i]);

            solve(idx + 1, digits, result, curr, map);

            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if(digits.length() == 0) return result;

        HashMap<String,String> map = new HashMap<>();

        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");

        solve(0, digits, result, new StringBuilder(), map);

        return result;
    }
}