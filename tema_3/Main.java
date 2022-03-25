package com.company;

public class Main {

    public static void main(String[] args) {

        PizzaFactory pizzaFactory = new PizzaFactory();
        Client client = new Client(pizzaFactory);
        pizzaFactory.setState(true);
        pizzaFactory.setState(false);

        Order o1 = new Order();
        o1.execute(pizzaFactory);

        Order o2 = new Order();
        o2.execute(pizzaFactory);
    }
}
