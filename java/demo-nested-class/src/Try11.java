public class Try11 {
  String thing;
  int level;

  public Try11(Builder builder) { // inner class
    this.thing = builder.thing;
    this.level = builder.level;
  }

  public static Builder builder() { // it is learning for spring boot
    return new Builder(); // 用builder 第一步new obj
  }

  public static class Builder {
    String thing;
    int level;

    public Builder thing(String thing) {
      this.thing = thing;
      return this;
    }

    public Builder level(int level) {
      this.level = level;
      return this;
    }

    public Try11 build() {
      return new Try11(this); // set 好哂最後比番主角 class
    }

  }



  public static void main(String[] args) {
    // Student.Bag sb = new Student.Bag(); // all private
    Try11 try123 = Try11.builder().level(5).thing("sleep").build();
  }
}
