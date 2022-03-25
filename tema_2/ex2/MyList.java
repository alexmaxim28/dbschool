package com.company;

public class MyList<T> {
    T[] arr;
    int sizeMax;
    int sizeAcc;

    public MyList(int dimension) {
        arr = (T[]) new Object[dimension];
        sizeAcc = 0;
        sizeMax = dimension;
    }

    public void add(T element) {
        if (sizeAcc >= sizeMax)
            System.out.println("You can't add another element. Array is at it's maximum capacity.");
        else
            arr[sizeAcc++] = element;
    }

    public void print(){
        for (int i = 0; i < arr.length; i ++)
            System.out.println(arr[i]);
    }

    public boolean lookup(T element)
    {
        for (int i = 0; i < arr.length; i ++)
            if(arr[i].equals(element))
                return true;
        return false;
    }

    public static void main(String[] args)
    {
        MyList arry = new MyList(3);

        arry.add(3);
        arry.add("String");
        arry.add(9.123);

        if (arry.lookup(4))
            System.out.println("Element found");
        else
            System.out.println("Element not found");
        System.out.println();

        if (arry.lookup("String"))
            System.out.println("Element found");
        else
            System.out.println("Element not found");
        System.out.println();

        System.out.println("Print array: ");
        arry.print();

        System.out.println();
        arry.add(12);

    }

}
