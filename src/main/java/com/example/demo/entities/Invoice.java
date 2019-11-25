package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Date sellDate;

    @ManyToOne
    @Where(clause = "role = 'C'")
    private User customer;

    @ManyToOne
    @Where(clause = "role = 'S'")
    private User seller;

    @ManyToMany
    private List<Product> products;

    public Invoice(Date sellDate, User customer, User seller, List<Product> products) {
        this.sellDate = sellDate;
        this.customer = customer;
        this.seller = seller;
        this.products = products;
    }
}

