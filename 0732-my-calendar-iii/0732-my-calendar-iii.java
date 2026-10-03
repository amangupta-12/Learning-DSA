
class MyCalendarThree {
     TreeMap<Integer,Integer> map;
    public MyCalendarThree() {
         map = new TreeMap<>();
    }
    
    public int book(int st, int et) {
         map.put(st,map.getOrDefault(st,0)+1);
        map.put(et,map.getOrDefault(et,0)-1);

         int count = 0;
         int max = 0;
        for(Integer i : map.keySet()){
            count += map.get(i);

            if(count > max){
                max = count;
            }
           
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */