package com.company;

import java.util.Arrays;

public class BusStation  {

   Vehicle[] vehicles = new Vehicle[5];

    public BusStation(){}

    public BusStation(Vehicle[] vehicles){
        this.vehicles = vehicles;
    }

    public void showAllVehicles()
    {
        for(int i = 0; i < vehicles.length; i++)
            System.out.println( vehicles[i].getClass().getSimpleName()+ " : " + vehicles[i].display());
    }

    public double showTotalProfit(){

        double profit = 0;

        for(Vehicle vehicle : vehicles){
            profit += vehicle.profit();
        }
        return profit;
    }

    public void sortVehicles(){
        Arrays.sort(vehicles);
    }

    public static void main(String[] args) {

    }
}
