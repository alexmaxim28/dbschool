package com.company;

public class Test {

    public static void main(String[] args) {

        BusStation bs = new BusStation();

        bs.vehicles[0] = new Bus(true, "green", 13, 5 );
        bs.vehicles[1]= new Bus(false, "red", 11, 4 );
        bs.vehicles[2] = new Taxi(true, "yellow", 3, 20 );
        bs.vehicles[3] = new Taxi(false, "white", 4, 22 );
        bs.vehicles[4] = new Bus(false, "black", 17, 2.5 );


        bs.showAllVehicles();
        System.out.println("\n" + "Calculam tot profitul : ");
        System.out.println(bs.showTotalProfit());
        System.out.println("\n" + "Sortam vehiculele dupa profit : ");
        bs.sortVehicles();
        bs.showAllVehicles();


    }

}
