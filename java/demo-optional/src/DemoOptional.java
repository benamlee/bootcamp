import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DemoOptional {
  public static void main(String[] args) throws Exception {


    // Optional<Book> -> Book -> String
    Optional<Book> o = getBook(); // call Mehtod
    if (!o.isPresent()) {

    }
    o.ifPresent(e -> {

    });

    List<Book> books = new ArrayList<>();
    books.add(new Book("John"));
    books.add(new Book("Mary"));
    books.add(new Book("Peter"));

    Optional<Book> book = books.stream() // here, even there is no books.streak, Optional book is not null, but Optional book carry a message no books
        .filter(b -> b.author.startsWith("T")) //
        .findAny();

    book.ifPresent(b -> {
      System.out.println(b);
      // codes..
    });

    // System.out.println(book.get()); // throw NoSuchElementError

    if (book.isPresent()) {
      System.out.println(book.get());
    } else {
      System.out.println("No Book found");
    }

    Optional<Book> book2 = Optional.of(new Book("Eric"));
    // Optional<Book> book3 = Optional.of(null); // Exception
    Optional<Book> book4 = Optional.ofNullable(null);
    System.out.println(book4.isPresent()); // false
    Optional<Book> book5 = Optional.ofNullable(new Book("Jenny"));
    Optional<Book> book6 = Optional.empty();
    System.out.println(book6.isPresent()); // false
    System.out.println(book6); // Optional.empty

    Optional<Book> book7 = null;
    System.out.println(book7); // null

    // Optional<Book> -> Book
    Book newBook = book6.orElse(new Book("Default"));
    Book newBook2 = book4.orElse(null);
    System.out.println(book6); // Optional.empty
    System.out.println(book4); // Optional.empty
    // 無需比 null to outside, bad presentation, 用isPresent()
    // because null forever cannot .method()!!!!!!!!!!!!!!!!!!!!!!!
    // may return pass something outside

    Book newBook3 = book6.orElseGet(() -> new Book("default"));
    Book newBook4 = book6.orElseThrow(() -> new Exception()); // here cos book6 is Optional.empty
    // so throw an Exception
  }

  public static Optional<Book> getBook() {
    // get book logic...
    return Optional.empty();
  }
}
