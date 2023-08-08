package hashmap1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import hashset1.Book;

public class DemoHashMap2 {
  public static void main(String[] args) {
    HashMap<Integer, Book> books = new HashMap<>();
    // key = Address of Integer or value of Integer?
    books.put(Integer.valueOf(128), new Book("dummy", "Eric1"));
    // Integer has itself override equals() and hashCode()
    // so the same value will be the same key
    books.put(128, new Book("dummy", "Eric222")); // auto-box and override
    System.out.println(books.size()); // 1

    HashMap<Author, Book> bookMap = new HashMap<>();
    // Author unique key? -> equals(), hashCode()
    Author author1 = new Author("John", 30);
    Author author2 = new Author("John", 29);
    bookMap.put(author1, new Book("dummy", "Book3"));
    bookMap.put(author2, new Book("dummy", "Book4")); // Author override name only -> same name same author
    System.out.println(bookMap.size()); // 1

    // ArrayList<ArrayList<String>> strs = new ArrayList<>(); // 少會咁用

    // ArrayList<int>; // 兩樣野不能有 ArrayList
    // ArrayList<Integer[]>; // primitives & Array

    HashMap<Author, ArrayList<Book>> bookMap2 = new HashMap<>();
    ArrayList<Book> booklist1 = new ArrayList<>();
    booklist1.add(new Book("dummy", "Book1")); // 一本
    booklist1.add(new Book("dummy", "Book2")); // 兩本
    ArrayList<Book> booklist2 = new ArrayList<>();
    booklist2.add(new Book("dummy", "Book3")); // 一本
    booklist2.add(new Book("dummy", "Book4")); // 兩本
    // new 哂之後放入去
    bookMap2.put(author1, booklist1);
    bookMap2.put(author2, booklist2); // 作者一樣，override booklist2
    System.out.println(bookMap2.size()); // 1 ，一個作者

    // Loop bookMap2, print out all the books from each Author
    for (Map.Entry<Author, ArrayList<Book>> entry : bookMap2.entrySet()) { // entry is just a name given to use here represent key+value
      // System.out.println(author.getKey().name);
      for (Book book : entry.getValue()) // entry.getValue() -> ArrayList<Book>
        System.out
            .println("Author Name: " + entry.getKey().name + ", Author Age: "
                + entry.getKey().age + ", Book Name: " + book.getName());
    } // 保留了 第一個 age 30 的 John 做 key


    // Author name1 = new Author("John", 0); skipped
    for (Book book : bookMap2.get(new Author("John", 0))) { // new Author("John", 0) is the key // normal use a name // 0 is age, useless
      System.out.println(book); // Value is ArrayList<Book>, for loop each book, sout book.toString, override .toString
    }

  }
}
