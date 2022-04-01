package com.company;

public class Taxi extends Vehicle {

    int noPassengers;
    double ticketPrice;

    public Taxi(){

    }

    public Taxi(boolean functional, String color, int noPassengers, double ticketPrice){
        super(functional, color);
        this.noPassengers = noPassengers;
        this.ticketPrice = ticketPrice;
    }

    public double charge(){
        return ticketPrice;
    }

    public double profit(){
        return 0.25 * noPassengers * ticketPrice;
    }

    public String display(){

            if(getFunctional())
                return "Color : " + getColor() + ", " + " Stare : functional, " + " Number of passengers : " + noPassengers + ", Ticket price : " + ticketPrice;
            else
                return "Color : " + getColor() + ", " + " Stare : not functional, " + " Number of passengers : " + noPassengers + ", Ticket price : " + ticketPrice;
    }


    public static void main(String[] args) {

    }

}
