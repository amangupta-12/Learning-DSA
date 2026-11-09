class Solution {
    public String reverseWords(String str) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder dup = new StringBuilder(str);
        dup.append(" ");
        String s = dup.toString();
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }else{
                if(sb.length() > 0){
                    list.add(sb.toString());
                    sb.setLength(0);
                }
            }
            i++;
        }
        sb.setLength(0);
        for(int j=list.size()-1;j >= 0;j--){
            sb.append(list.get(j));
            if(j != 0) sb.append(" ");
        }
        return sb.toString();
    }
}