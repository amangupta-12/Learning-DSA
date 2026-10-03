class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int st, int et) {
        map.put(st,map.getOrDefault(st,0)+1);
        map.put(et,map.getOrDefault(et,0)-1);

        int count = 0;
        for(Integer i : map.keySet()){
            count += map.get(i);

            if(count > 1){
                map.put(st,map.get(st)-1);
                map.put(et,map.get(et)+1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */