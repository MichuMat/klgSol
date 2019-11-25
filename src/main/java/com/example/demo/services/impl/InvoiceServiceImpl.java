package com.example.demo.services.impl;

import com.example.demo.commands.InvoiceCommand;
import com.example.demo.entities.Invoice;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repositories.InvoiceRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private static final String CUSTOMER_ROLE = "C";
    private InvoiceRepository invoiceRepository;
    private UserRepository userRepository;

    @Override
    public List<Invoice> getInvoices(String customerName) {
        Optional<User> customer = userRepository.findByNameAndRole(customerName, new Role(CUSTOMER_ROLE));

        if (!customer.isPresent()) {
            throw new NotFoundException();
        }

        List<Invoice> invoices = invoiceRepository.findAllByCustomer(customer.get());
        return invoices;
    }

    @Override
    public Invoice createInvoice(InvoiceCommand invoiceCommand) {
        Invoice invoice = new Invoice(invoiceCommand.getDate(),
                invoiceCommand.getCustomer(),
                invoiceCommand.getSeller(),
                invoiceCommand.getProducts());

        return invoiceRepository.save(invoice);
    }


}

