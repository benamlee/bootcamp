package com.example.demoresttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor // Jaskson
@AllArgsConstructor
@Getter // Getter + No-Arg Constructor
// @Setter
// @ToString
public class User {
    private long id;
    private String name;
    private String username;
    private String email;
    private Adderss adderss;
    private String phone;
    private String website;
    private Company company;

    // @NoArgsConstructor
    // @AllArgsConstructor
    @Getter
    // @Setter
    // @ToString
    public static class Adderss {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        // @NoArgsConstructor
        // @AllArgsConstructor
        @Getter
        // @Setter
        // @ToString
        public static class Geo {
            private String lat;
            private String lng;
        }
    }

    // @NoArgsConstructor
    // @AllArgsConstructor
    @Getter
    // @Setter
    // @ToString
    public static class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    }

}
