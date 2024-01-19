package javalang.java9.features;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindGitConflict {

    public static void main(String...args) throws IOException {
        Files.lines(Paths.get("resources/index.html"))
                .dropWhile(line -> !line.contains("<<<<<<<<<"))
                .skip(1)
                .takeWhile(line -> !line.contains(">>>>>>")).forEach(System.out::println);

        // Creating a mapping of Price with set of authors.
        // Creating a mapping of one attribute with set of other attribute
        List<Book> books = new ArrayList<>();
        Map<Double, Set<String>> authorsSellingPrice = books.stream().collect(
                Collectors.groupingBy(Book::getPrice,
                                      Collectors.flatMapping(
                                              book -> book.getAuthors().stream(),
                                              Collectors.toSet()
                                      )
                )
        );

        Optional<Book> bookOptional = Optional.empty();
        // In optional we do not have any isEmpty Method. We have to use negate or use if else
        if (!bookOptional.isPresent()) {
            System.out.println("No book");
        }
        if (bookOptional.isPresent()) {
            System.out.println(bookOptional.get());
        } else {
            System.out.println("No book");
        }

        bookOptional.ifPresentOrElse(System.out::println, () -> {
            System.out.println("No Book");
        });


        Book book = new Book("Elements of Programming", List.of("Adnan Aziz", "Amit Prakash"), 18.80);
        bookOptional.ifPresentOrElse(System.out::println, () -> {
            System.out.println("No Book");
        });

        //Chaining Optionals

        Optional<Book> newBookOptional1 = Optional.empty();
        Optional<Book> newBookOptional2 = Optional.empty();
        Optional<Book> newBookOptional3 = Optional.of(new Book("Alchemist", List.of("Paulo Cohelo"), 59.99));

        // We have to do a get and we would get exception if all are empty
        Book newBook = newBookOptional1.orElse(newBookOptional2.orElse(newBookOptional3.get()));

        //Optional Chaining
        Optional<Book> newBookOptional = newBookOptional1.or(() -> newBookOptional2).or(() ->newBookOptional3);
        Stream<Book> bookStream = newBookOptional.stream();

        // Only underscore not allowed
        //String _ = "Underscore";

        // Java 9
        FileInputStream fileInputStream = new FileInputStream("resources/index.html");
        readFileJava8(fileInputStream);

        fileInputStream = new FileInputStream("resources/index.html");
        readFileJava9(fileInputStream);

        // Diamond operators now work with ArrayList
        List<String> nameList = new ArrayList<>() {
            @Override
            public boolean add(String s) {
                System.out.println("Adding" + s);
                return super.add(s);
            }
        };

    }


    private static void readFileJava8(FileInputStream fileInputStream ) {
        FileInputStream fileInputStream1 = fileInputStream;
        // In Java 8 we had to create a new reference
        try (fileInputStream1){
            fileInputStream1.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void readFileJava9(FileInputStream fileInputStream ) {
        // fileInputStream must be effectively final
        // effectively final means either final or is not assigned after initialisation
        // works even if fileInputStream comes as method parameters
        try (fileInputStream){
            fileInputStream.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class Book {
        private String name;

        private List<String> authors;

        private double price;

        public Book(String name, List<String> authors, double price) {
            this.name = name;
            this.authors = authors;
            this.price = price;
        }

        @Override public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", authors=" + authors +
                    ", price=" + price +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getAuthors() {
            return authors;
        }

        public void setAuthors(List<String> authors) {
            this.authors = authors;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
