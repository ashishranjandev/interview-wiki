package javalang.interviews;

import java.util.HashSet;
import java.util.Set;

public final class ImmutableClass {
    private final int id;

    private final String name;

    private final Set<Integer> set;

    public ImmutableClass(int id, String name, Set<Integer> set) {
        this.id = id;
        this.name = name;
        this.set = new HashSet<>(set);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Integer> getSet() {
        return new HashSet<>(set);
    }
}
