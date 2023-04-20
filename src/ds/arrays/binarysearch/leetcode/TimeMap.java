package ds.arrays.binarysearch.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

    public static void main (String...args) {
        System.out.println("Input is");
        System.out.println("[\"TimeMap\",\"set\",\"get\",\"get\",\"set\",\"get\",\"get\"]");
        System.out.println("[[],[\"foo\",\"bar\",1],[\"foo\",1],[\"foo\",3],[\"foo\",\"bar2\",4],[\"foo\",4]," +
                                   "[\"foo\",5]]");

        TimeMap map1 = new TimeMap();
        map1.set("foo","bar",1);
        System.out.println(map1.get("foo",1));
        System.out.println(map1.get("foo",3));
        map1.set("foo","bar2",4);
        System.out.println(map1.get("foo",4));
        System.out.println(map1.get("foo",5));

        System.out.println("Input is");
        System.out.println("[\"TimeMap\",\"set\",\"set\",\"get\",\"get\",\"get\",\"get\",\"get\"]");
        System.out.println("[[],[\"love\",\"high\",10],[\"love\",\"low\",20],[\"love\",5],[\"love\",10],[\"love\"," +
                                   "15],[\"love\",20],[\"love\",25]]");
        TimeMap map2 = new TimeMap();
        map1.set("love","high",10);
        map1.set("love","low",20);

        System.out.println(map1.get("love",5));
        System.out.println(map1.get("love",10));
        System.out.println(map1.get("love",15));
        System.out.println(map1.get("love",20));
        System.out.println(map1.get("love",25));


    }

    Map<String, List<TimeValue>> values;

    public TimeMap() {
        values = new HashMap<>();

    }

    public void set(String key, String value, int timestamp) {
        List<TimeValue> valuesList = values.containsKey(key) ? values.get(key) : new ArrayList<TimeValue>();
        valuesList.add(new TimeValue(value, timestamp));
        values.put(key, valuesList);
    }

    public String get(String key, int timestamp) {
        if (!values.containsKey(key) || values.get(key).get(0).timestamp > timestamp) {
            return "";
        }


        int startIndex = 0;
        int left = 0;
        int mid = 0;
        int right = values.get(key).size() - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (values.get(key).get(mid).timestamp == timestamp) {
                return values.get(key).get(mid).val;
            } else if (values.get(key).get(mid).timestamp > timestamp) {
                right = mid - 1;
            } else {
                startIndex = (mid > startIndex) ? mid : startIndex ;
                left = mid + 1;
            }
        }
        return values.get(key).get(startIndex).val;
    }
}

class TimeValue {
    String val;
    int timestamp;

    public TimeValue(String val, int time){
        this.val = val;
        timestamp = time;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
