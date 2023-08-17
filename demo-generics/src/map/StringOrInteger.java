package map;

public final class StringOrInteger { // it doesnt work
  private final Object value;

  private StringOrInteger(Object value){
    this.value=value;
  }

  public static StringOrInteger of(String value){
    return new StringOrInteger(value);
  }

  public static StringOrInteger of(Integer value){
    return new StringOrInteger(value);
  }
}
