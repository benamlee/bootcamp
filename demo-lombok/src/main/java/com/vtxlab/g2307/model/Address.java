package com.vtxlab.g2307.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
// @RequiredArgsConstructor
@Builder
public class Address {
    private String addrLine1;
    private String addrLine2;
    private String addrLine3;
    // @NonNull
    private Country country;

    public Address(Country country) {
        if (country == null)
            throw new NullPointerException();
        this.country = country;
    }

    public static void main(String[] args) {
        Address a1 = new Address(Country.HK);
        // Address a3 = new Address(null);
        Address a2 = Address.builder() //
                .addrLine1("") //
                .addrLine2("") //
                .addrLine3("") //
                .country(Country.US) //
                .build();

        System.out.println(a2);
        System.out.println(a1);
        System.out.println(
                Address.builder().addrLine1("a").addrLine2("b").addrLine3("b"));
    }
}
