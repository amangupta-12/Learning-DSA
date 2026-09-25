class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        list.add(prev);
       
        for (int i = 1; i < numRows; i++) {
            List<Integer> val = new ArrayList<>();
            val.add(1);
            for (int j = 1; j < prev.size(); j++) {
                val.add(prev.get(j - 1) + prev.get(j));
            }
            val.add(1);
            list.add(val);
            prev = val;
        }
        return list;
    }
}