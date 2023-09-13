public enum Currency {
  USD(1, "US Dollor"), //
  HKD(2, "Hong Kong Dollor"), //
  CNY(3, "Chinese Yuan Renminbi"), //
  GBP(4, "British Pound Sterling"), //
  ;

  private int id;
  private String desc;

  private Currency(int id, String desc) {
    this.id = id;
    this.desc = desc;
  }

  public int getId() {
    return this.id;
  }

  public String getDesc() {
    return this.desc;
  }

  public static Currency getCurrency(int id) {
    // values()
    for (Currency currency : Currency.values()) { // Currency enum入面所有野
      //  Currency.values() 就咁寫 values() 都得, cos 同 class
      if (currency.id == id)
        return currency;
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println(Currency.valueOf("HKD").getDesc());
    System.out.println(Currency.HKD==Currency.valueOf("HKD"));
    // System.out.println(Currency.valueOf("Abc")); // not found, error
  }

}
