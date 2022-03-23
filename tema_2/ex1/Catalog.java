package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Catalog{

    Map<Integer, TreeSet<Student>> catalog = new HashMap<>();


    public Catalog()
    {
        for(int i = 0; i < 11; i ++)
        {
            catalog.put(i, new TreeSet<>());
        }
    }

    public void addStudent(Student stud)
    {
        int roundedGrade = (int)Math.round(stud.getGrade());
        catalog.get(roundedGrade).add(stud);
    }

    public void listStudents()
    {
        System.out.println(catalog);
    }

}
