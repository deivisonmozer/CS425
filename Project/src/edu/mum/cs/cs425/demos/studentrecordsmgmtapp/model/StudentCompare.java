package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.util.Comparator;

public class StudentCompare implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }


}
