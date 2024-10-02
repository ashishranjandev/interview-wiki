package interview.uprnetwrkz;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;





public class DedupingTopNCollection<K, E> {

    private final PriorityQueue<E> minHeap;
    private final int maxCapacity;
    private final Comparator<E> comparator;
    private final Function<E, K> keyMapper;
    private final Map<K, E> elementMap;


    public DedupingTopNCollection(int maxCapacity, Comparator<E> comparator, Function<E, K> keyMapper) {
        this.maxCapacity = maxCapacity;
        this.comparator = comparator;
        this.minHeap = new PriorityQueue<>(comparator);
        this.keyMapper = keyMapper;
        this.elementMap = new HashMap<>();

    }

    /**
     * Adds an element to the collection.
     */
    public boolean add(E element) {
        K key = keyMapper.apply(element);
        if (elementMap.containsKey(key)) {
            E existingElement = elementMap.get(key);
            if (comparator.compare(element, existingElement) > 0) {
                minHeap.remove(existingElement);
                minHeap.offer(element);
                elementMap.put(key, element);
            }
        } else {
            elementMap.put(key, element);
            minHeap.offer(element);
        }

        if (minHeap.size() > maxCapacity) {
            E smallestElement = minHeap.poll();
            elementMap.remove(keyMapper.apply(smallestElement));
        }
        return true;
    }

    public List<E> getElements() {
        List<E> topElements = new ArrayList<>(minHeap);
        topElements.sort(comparator.reversed());
        return topElements;
    }

}