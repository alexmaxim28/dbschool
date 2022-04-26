package com.example.tema_10.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Carts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Comparable<Cart>{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartEntry> cartEntries;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    //Calculate how many products are in a order
    public Integer numberOfProductsInOrder(){
        Integer quantity = 0;
        for(CartEntry product : cartEntries){
            quantity+=product.getQuantity();
        }
        return quantity;
    }

    //compare to basec on how many products are in a order
    @Override
    public int compareTo(Cart o) {
        return this.numberOfProductsInOrder()-o.numberOfProductsInOrder();
    }
}
