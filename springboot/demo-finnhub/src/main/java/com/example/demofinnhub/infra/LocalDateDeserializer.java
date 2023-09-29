package com.example.demofinnhub.infra;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

  public LocalDateDeserializer() {
    this(null);
  }

  protected LocalDateDeserializer(Class<LocalDate> t) {
    super(t);
  }
  
  @Override
  public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException {
    return LocalDate.parse(p.getValueAsString()); // Customize the parsing as needed
  }
}
