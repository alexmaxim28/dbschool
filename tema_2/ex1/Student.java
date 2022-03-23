package com.company;

public class Student implements Comparable<Student> {
    private String name;
    private Double grade;

    public Student(String Name, Double Grade){
        name = Name;
        grade = Grade;
    }
    public Double getGrade(){
        return this.grade;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String Name){
        name = Name;
    }

    public void setGrade(Double Grade){
        grade = Grade;
    }
    public static int stringCompare(String str1, String str2)
    {
        int lmin = Math.min(str1.length(), str2.length());

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
        return 0;
    }

    public int compareTo(Student s)
    {
        if(Double.compare(this.grade, s.grade)  == 0)
        {
            return stringCompare(this.getName(), s.getName());
        }
        return Double.compare(this.getGrade(), s.getGrade());
    }
    public String toString(){
        return name + ": " + grade;
    }

}
