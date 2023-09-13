package com.example;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class UppercaseMatcher extends TypeSafeMatcher<String> {
    @Override
    protected boolean matchesSafely(String str) {
        // return str.matches("[A-Za-z0-9]+");
        // return str.matches("[0-9][A-Z]+");
        return str.matches("[A-Z]+");
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("String should contain uppercase letter only.");
    }

    public static Matcher<String> containUppercaseOnly() {
        return new UppercaseMatcher();
    }

}
