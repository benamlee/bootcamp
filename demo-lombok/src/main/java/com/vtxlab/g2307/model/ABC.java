package com.vtxlab.g2307.model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ABC {
  private int a;
  private String b;
  private Double c;
  private Car d;

  public static void main(String[] args) {
    // ABC b=new ABC();
    ABC a = ABC.builder().a(100).b("hello").c(900D).d(new Car(60, 7D)).build();
  }
    
}
