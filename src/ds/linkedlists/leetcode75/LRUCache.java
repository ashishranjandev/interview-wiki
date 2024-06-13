package ds.linkedlists.leetcode75;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    public static void main(String...args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println("Input is \"LRUCache\",\"put\",\"put\",\"get\",\"put\",\"get\",\"put\",\"get\",\"get\",\"get\"");
        System.out.println("[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]");
        System.out.println("Expected output is [null, null, null, 1, null, -1, null, -1, 3, 4]");
        System.out.print("Actual out put is [");
        System.out.print(" null, ");
        lruCache.put(1, 1);
        System.out.print(" null, ");
        lruCache.put(2, 2);
        System.out.print(" null, ");

        System.out.print(lruCache.get(1) + ",");

        lruCache.put(3, 3);
        System.out.print(" null, ");

        System.out.print(lruCache.get(2) + ",");

        lruCache.put(4, 4);
        System.out.print(" null, ");

        System.out.print(lruCache.get(1) + ", ");
        System.out.print(lruCache.get(3) + ", ");
        System.out.print(lruCache.get(4) + "]");

        System.out.println();
        System.out.println();
        System.out.println("Input is [\"LRUCache\",\"put\",\"put\",\"put\",\"put\",\"get\",\"get\"]");
        System.out.println("[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]");
        System.out.println("Expected output is [null,null,null,null,null,-1,3]");
        System.out.print("Actual output is [null,");
        lruCache = new LRUCache(2);
        System.out.print(" null,");
        lruCache.put(2, 1);
        System.out.print(" null,");
        lruCache.put(1, 1);
        System.out.print(" null,");
        lruCache.put(2, 3);
        System.out.print(" null,");
        lruCache.put(4, 1);
        System.out.print(lruCache.get(1) + ",");
        System.out.print(lruCache.get(2) + "]");
    }

    private Integer capacity;

    // Mapping Key to Node in DLL
    private Map<Integer, CacheNode> cache;

    // Left and right pointers of DLL
    CacheNode left, right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity + 1);

        this.left = new CacheNode(0,0);
        this.right = new CacheNode(0,0);
        this.left.next = right;
        this.right.prev = left;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            removeNode(cache.get(key));
            insertNode(cache.get(key));
            return cache.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.get(key).value = value;
            removeNode(cache.get(key));
            insertNode(cache.get(key));
        } else {
            cache.put(key, new CacheNode(key, value));
            insertNode(cache.get(key));
            if (cache.size() > capacity) {
                cache.remove(left.next.key);
                removeNode(left.next);
            }
        }
    }

    private void removeNode(CacheNode node) {
        CacheNode prev = node.prev;
        CacheNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void insertNode(CacheNode newNode) {
        CacheNode prev = right.prev;
        CacheNode next = right;

        newNode.next = next;
        newNode.prev = prev;

        prev.next = newNode;
        next.prev = newNode;
    }

    class CacheNode {
        Integer key;
        Integer value;

        CacheNode prev;

        CacheNode next;

        CacheNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}