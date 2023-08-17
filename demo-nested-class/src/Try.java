public class Try {
  String thing;
  int level;

  private Try(Builder builder) {
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

    public Try build() {
      return new Try(this); // set 好哂最後比番主角 class
    }

  }



  public static void main(String[] args) {
    // Student.Bag sb = new Student.Bag(); // all private

  }
}
