package interview.pdnh_pb_wlsr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CacheWithExpiryAndPriority {

    private int capacity;

    private Map<String, CacheItem> keyToValue;

    private TreeMap<Long, HashSet<String>> expiryMap;

    private List<LinkedHashSet<String>> priorityValues;

    public CacheWithExpiryAndPriority(int capacity) {
        this.capacity = capacity;
        this.keyToValue = new HashMap<>();
        this.expiryMap = new TreeMap<>();
        this.priorityValues = new ArrayList<>(10);
        for (int index = 0; index < 10; index++) {
            priorityValues.add(new LinkedHashSet<>());
        }
    }

    static class CacheItem {
        String key;

        Integer value;

        int priority;

        long expiry;

        public CacheItem(String key, Integer value, int priority, long expiry) {
            this.key = key;
            this.value = value;
            this.priority = priority;
            this.expiry = expiry;
        }

        @Override public String toString() {
            return "CacheItem{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    ", priority=" + priority +
                    ", expiry=" + expiry +
                    '}';
        }
    }

    public Integer get(String key) {
        System.out.println("Trying to get key "+ key + " from cache " + keyToValue);
        if (keyToValue.containsKey(key)) {
            CacheItem cacheItem = keyToValue.get(key);
            clearFromPriorityValues(cacheItem);
            addToPriorityValues(cacheItem);
            return cacheItem.value;
        }
        return -1;
    }

    public void set(String key, int value, int priority, long expiry) {
        CacheItem cacheItem = new CacheItem(key, value, priority, expiry);
        System.out.println("Adding cache item " + cacheItem);
        if (keyToValue.containsKey(key)) {
            clearFromPriorityValues(cacheItem);
            clearFromExpiryMap(keyToValue.get(key));
            addToPriorityValues(cacheItem);
            addToExpiryMap(cacheItem);
        } else {
            checkCapacity();
        }
        keyToValue.put(key, cacheItem);
        System.out.println("After adding the cache item cache " + keyToValue);
        System.out.println("After adding the cache item expiry map " + expiryMap);
        System.out.println("After adding the cache item priority Values" + priorityValues);
    }

    private void checkCapacity() {
        if (keyToValue.size() == capacity) {
            String keyToBeRemoved = null;
            if (!expiryMap.isEmpty() && expiryMap.firstKey() <= 600) {
                Set<String> setOfExpiredKeys = expiryMap.get(expiryMap.firstKey());
                for (String expiredKey : setOfExpiredKeys) {
                    keyToBeRemoved = expiredKey;
                    break;
                }
                clearFromExpiryMap(keyToValue.get(keyToBeRemoved));
                clearFromPriorityValues(keyToValue.get(keyToBeRemoved));
            } else {
                for (int index = 0; index < priorityValues.size(); index++) {
                    if (priorityValues.get(index) != null && !priorityValues.get(index).isEmpty()) {
                        LinkedHashSet<String> linkedHashSet = priorityValues.get(index);
                        keyToBeRemoved = linkedHashSet.stream().findFirst().get();
                    }
                }
                clearFromExpiryMap(keyToValue.get(keyToBeRemoved));
                clearFromPriorityValues(keyToValue.get(keyToBeRemoved));
            }
            keyToValue.remove(keyToBeRemoved);
        }
    }

    private void clearFromPriorityValues(CacheItem cacheItem) {
        LinkedHashSet<String> linkedHashSet = priorityValues.get(cacheItem.priority - 1);
        linkedHashSet.remove(cacheItem.key);
        priorityValues.set(cacheItem.priority - 1, linkedHashSet);
    }

    private void addToPriorityValues(CacheItem cacheItem) {
        LinkedHashSet<String> linkedHashSet = priorityValues.get(cacheItem.priority - 1);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet<>();
        }
        linkedHashSet.add(cacheItem.key);
        priorityValues.add(cacheItem.priority - 1, linkedHashSet);
    }

    private void clearFromExpiryMap(CacheItem cacheItem) {
        expiryMap.get(cacheItem.expiry).remove(cacheItem.key);
    }

    private void addToExpiryMap(CacheItem cacheItem) {
        HashSet<String> keysWithExpiry = expiryMap.get(cacheItem.expiry);
        keysWithExpiry.add(cacheItem.key);
        expiryMap.put(cacheItem.expiry, keysWithExpiry);
    }

    public static void main(String...args) {
        CacheWithExpiryAndPriority cache = new CacheWithExpiryAndPriority(5);

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
