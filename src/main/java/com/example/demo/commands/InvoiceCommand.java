package com.example.demo.commands;

import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceCommand {

    private Date date;
    private User customer;
    private User seller;
    private List<Product> products;
}
