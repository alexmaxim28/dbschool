package com.company;

import static com.company.Student.stringCompare;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("Daria",4.3);
        Student s2 = new Student("Mihai",9.8);
        Student s3 = new Student("Andreea",6.4);
        Student s4 = new Student("Alex",7.9);
        Student s5 = new Student("Andrei",9.8);
        Student s6 = new Student("Miruna",9.4);

        Catalog c = new Catalog();

        c.addStudent(s1);
        c.addStudent(s2);
        c.addStudent(s3);
        c.addStudent(s4);
        c.addStudent(s5);
        c.addStudent(s6);

        c.listStudents();
    }
}
