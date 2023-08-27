package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<>();
        array.add(new Student(110001, "Dave", LocalDate.parse("1951-11-18")));
        array.add(new Student(110002, "Anna", LocalDate.parse("1990-12-07")));
        array.add(new Student(110003, "Erica", LocalDate.parse("1974-01-31")));
        array.add(new Student(110004, "Carlos", LocalDate.parse("2009-08-22")));
        array.add(new Student(110005, "Bob", LocalDate.parse("1990-03-05")));

        printListOfStudents(array);
        System.out.println("");
        getListOfPlatinumAlumniStudents(array);
        System.out.println("");
        int[] values = {19,9,11,0,12};
        System.out.println("Second Biggest: "+ findSecondBiggest(values));
    }
    public static void printListOfStudents(ArrayList<Student> array){
        Collections.sort(array, new StudentCompare());
        array.forEach(x-> System.out.println(x.toString()));
    }

    public static void getListOfPlatinumAlumniStudents(ArrayList<Student> array){
        array.stream().filter(x-> x.dateOfAdmission.getYear() > 30).sorted((x1,x2)->x1.getDateOfAdmission().compareTo(x2.getDateOfAdmission())).forEach(System.out::println);
    }
    public static void printHelloWorld(int[] array){
        for(int x : array){
            if(x % 5 == 0)System.out.println("Hello");
            if(x % 7 == 0)System.out.println("World");
            if(x % 5 == 0 && x % 7 == 0)System.out.println("Hello World");

        }
    }
    public static int findSecondBiggest(int[] array){
        int max = Math.max(array[0], array[1]);
        int sec_max = Math.min(array[0], array[1]);
        for (int i = 2; i < array.length-1; i++) {
            int max_local = Math.max(array[i], array[i+1]);
            if(max_local > max){
                sec_max = max;
                max = max_local;
            }
            else
                sec_max = Math.max(sec_max, max_local);
        }
        return sec_max;
    }
}
