package com.example;

import java.util.ArrayList;
import java.util.List;
import lombok.NonNull;

public class Student {
    @NonNull
    private List<Subject> subjects;

    public Student() {
        subjects = new ArrayList<>();
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }
}
