package com.example.tema_9.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Client_Order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    @NotNull
    private Integer id;
    private Double price;

    @ManyToOne
    Customer customer;

    @OneToOne
    Payment payment;

}
