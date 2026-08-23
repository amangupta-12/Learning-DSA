class Solution {
    public String convert(String s, int numRows) {

StringBuilder[] rows = new StringBuilder[numRows];

if (numRows == 1 || s.length() <= numRows) return s;


for(int i=0;i<numRows;i++){
    rows[i] = new StringBuilder();
}

boolean godown = true;
int row = 0;

for(int i=0;i<s.length();i++){
    rows[row].append(s.charAt(i));

    if(row==0){
        godown = true;
    }else if(row == numRows-1){
        godown = false;
    }
    

    if(godown){
        row++;
    }else{ row--;}
}

    StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }

    return result.toString();
    }
}