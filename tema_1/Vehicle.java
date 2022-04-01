package com.company;


abstract public class Vehicle implements Comparable<Vehicle> {

    private boolean functional;
    private String color;

    public Vehicle(){}

    public Vehicle(boolean functional, String color){
        this.functional = functional;
        this.color = color;
    }

    public boolean getFunctional(){
        return this.functional;
    }

    public String getColor(){
        return this.color;
    }

    public void setFunctional(boolean functional){
        this.functional = functional;
    }

    public void setColor(String color){
        this.color = color;
    }

    public abstract double charge();
    public abstract double profit();
    public abstract String display();


    public int compareTo(Vehicle v1) {
        return (int)(profit() - v1.profit());
    }

    public static void main(String[] args) {

    }

}
