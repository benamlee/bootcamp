package com.example.demofinnhub.infra;

public class LocalDateSerializer extends StdSerializer<LocalDate> {

  public LocalDateSerializer() {
    this(null);
  }

  protected LocalDateSerializer(Class<LocalDate> t) {
    super(t);
  }

  @Override
  public void serialize(LocalDate value, JsonGenerator gen,
      SerializerProvider provider) throws IOException {
    gen.writeString(value.toString()); // Customize the serialization format if needed
  }
}
