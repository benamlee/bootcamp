package hashmap1;

import java.util.Objects;

public class Author {
  String name;
  int age;


  public Author(String name, int age) {
    this.name = name;
    this.age = age;
  }


  @Override
  public boolean equals(Object o) { 
    if (this == o)
      return true;
    if (!(o instanceof Author))
      return false;
    Author author = (Author) o;
    return author.name.equals(this.name); // name only now
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name); // name only now
  }
}
