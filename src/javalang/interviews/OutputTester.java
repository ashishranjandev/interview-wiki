package javalang.interviews;

import java.util.HashSet;
import java.util.Set;

public class OutputTester {

    public static void main(String...args) {
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(4);

        ImmutableClass immutableObject = new ImmutableClass(1, "Ashish", set);
        int id = immutableObject.getId();
        String name = immutableObject.getName();
        Set<Integer> setOfObject = immutableObject.getSet();

        System.out.println("Id is " + id);
        System.out.println("Name is " + name);
        System.out.println("Set is " + setOfObject);

        id = 7;
        name = "Akasa";
        setOfObject.add(6);
        setOfObject.add(8);
        set.add(10);

        System.out.println("Id is " + immutableObject.getId());
        System.out.println("Name is " + immutableObject.getName());
        System.out.println("Name is " + immutableObject.getSet());
    }
}
