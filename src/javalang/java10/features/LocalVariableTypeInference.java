package javalang.java10.features;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class LocalVariableTypeInference {

    public static void main(String...args) throws IOException {
        // Java can infer the variable type is String
        var bookName = "Head First";

        // Code looks cleaner, much less to type
        // type is already clear from right hand side
        var openJDKURL = new URL("https://openjdk.java.net");
        var connection = openJDKURL.openConnection();
        var openJDKStream = new BufferedInputStream(connection.getInputStream());

        // Where not to use
        // Getting the type would be difficult for code reader
        //var result = aService.findResult();

        //var is not a keyword, it is reserved type name
        //for backward compability for codes using it as identifier
        var var = "var";

        //Type inference is not new
        List<Integer> integerList = new ArrayList<>();

        List<Integer> emptyList = Collections.emptyList();

        Predicate<String> predicate = str -> str.length() > 3;

        // This does not compile as java cannot infer with given information
        //var predicate = str -> str.length() > 3;
        // This won't compile as well
        // var predicate = (String str) -> str.length() > 3;

        // This works -> ArrayList<Object> would be created
        var myList = new ArrayList<>();

        // Won't compile
        //var empty = null;

        // anonymous class, Object$1 extends Object would be used
        var obj = new Object() {};
        // This assignment would not work
        //obj = new Object();

        // Intersection types
        // the type of list will be <? extends Serializable and Comparable<>>
        var list = List.of(1, 2.0, "3");
    }
}
