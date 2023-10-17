package lld.cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

public class LRUWithExpiryAndPriority {

    static class CacheItem {
        String key;

        int value;

        int priority;

        int expiry;

        public CacheItem(String key, int value, int priority, int expiry) {
            this.key = key;
            this.value = value;
            this.priority = priority;
            this.expiry = expiry;
        }
    }

    private final int capacity;

    private final Map<String, CacheItem> keyToValue;

    private final TreeMap<Integer, LinkedHashSet<String>> priorityMap; // maintains insertion order, if multiple with same priority remove first one

    private final TreeMap<Integer, HashSet<String>> expiryMap; //if multiple with same expiry remove any

    public LRUWithExpiryAndPriority(int capacity) {
        this.capacity = capacity;
        this.keyToValue = new HashMap<>();
        this.priorityMap = new TreeMap<>();
        this.expiryMap = new TreeMap<>();
    }

    //O(1)
    public int get(String key) {
        if (contains(key)) {
            CacheItem cacheItem = keyToValue.get(key);
            clearFromPriorityMap(cacheItem); //remove existing  from priority map
            addToPriorityMap(cacheItem); //add to last to maintain LRU
            return cacheItem.value;
        }
        return -1;
    }

    //O(log n)
    public void set(String key, int value, int priority, int expiry) {
        if (contains(key)) {
            CacheItem cacheItem = keyToValue.get(key);
            clearFromPriorityMap(cacheItem);
            clearFromExpiryMap(cacheItem);
        } else {
            ensureCapacity();
        }
        CacheItem cacheItem = new CacheItem(key, value, priority, expiry);
        add(cacheItem);
    }

    private void add(CacheItem cacheItem) {
        String key = cacheItem.key;
        keyToValue.put(key, cacheItem);
        addToPriorityMap(cacheItem);
        addToExpiryMap(cacheItem);
    }

    private void addToExpiryMap(CacheItem cacheItem) {
        String key = cacheItem.key;
        expiryMap.computeIfAbsent(cacheItem.expiry, k -> new HashSet<>()).add(key); //O(log n), adding in treemap in sorted manner takes log(n)
    }

    //maintains LRU, remove least recent from front, add most recent at last
    private void addToPriorityMap(CacheItem cacheItem) {
        String key = cacheItem.key;
        priorityMap.computeIfAbsent(cacheItem.priority, k -> new LinkedHashSet<>()).add(key); //O(log n), adding in treemap in sorted manner takes log(n)
    }

    //O(1)
    private void clearFromPriorityMap(CacheItem cacheItem) {
        int priority = cacheItem.priority;
        String key = cacheItem.key;
        if (priorityMap.containsKey(priority)) {
            LinkedHashSet<String> keys = priorityMap.get(priority);
            keys.remove(key); //O(1)
            if (keys.isEmpty()) {
                priorityMap.remove(priority); //O(1)
            }
        }
    }

    //O(1)
    private void clearFromExpiryMap(CacheItem cacheItem) {
        int expiry = cacheItem.expiry;
        String key = cacheItem.key;
        if (expiryMap.containsKey(expiry)) {
            HashSet<String> keys = expiryMap.get(expiry);
            keys.remove(key); //O(1)
            if (keys.isEmpty()) {
                expiryMap.remove(expiry); //O(1)
            }
        }
    }

    //This is the main method they are looking for
    //Can have variations, explore this
    private void ensureCapacity() {
        if (keyToValue.size() == capacity) {
            String removedKey;
            int thresholdExpiryTime = 600; //take this from current time
            //1st case evict the one which is expired, you can remove any if multiple
            if (!expiryMap.isEmpty() && expiryMap.firstKey() <= thresholdExpiryTime) {
                removedKey = expiryMap.get(expiryMap.firstKey()).iterator().next(); //O(1)
                clearFromExpiryMap(keyToValue.get(removedKey));
                clearFromPriorityMap(keyToValue.get(removedKey));
            } else { //2nd case when no one expired, remove the one with least priority based on LRU
                removedKey = priorityMap.firstEntry().getValue().iterator().next(); //the key to be evicted is at the front //O(1)
                clearFromPriorityMap(keyToValue.get(removedKey));
                clearFromExpiryMap(keyToValue.get(removedKey));
            }
            keyToValue.remove(removedKey); //O(1)
        }
    }

    private boolean contains(String key) {
        return keyToValue.containsKey(key);
    }

    public static void main(String[] args) {
        LRUWithExpiryAndPriority cache = new LRUWithExpiryAndPriority(5);
        cache.set("A", 5, 1, 1000);
        cache.set("B", 15, 5, 500);
        cache.set("C", 0, 5, 2000);
        cache.set("D", 1, 5, 2000);
        cache.set("E", 10, 5, 3000);
        System.out.println(cache.get("C"));
        cache.set("F", 15, 5, 1000);
        cache.set("G", 0, 5, 2000);
        cache.set("H", 1, 1, 2000);
        System.out.println(cache.get("D"));
        cache.set("I", 10, 2, 2000);
        cache.set("E", 10, 2, 2000);
        cache.set("M", 10, 1, 3000);
    }
}
