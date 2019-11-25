package com.example.demo.controllers;

import com.example.demo.commands.InvoiceCommand;
import com.example.demo.entities.Invoice;
import com.example.demo.services.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/invoices")
public class InvoiceController {

    private InvoiceService invoiceService;

    @GetMapping("{username}")
    public ResponseEntity<List<Invoice>> getCustomerInvoices(@PathVariable String username) {
        List<Invoice> invoices = invoiceService.getInvoices(username);
        return invoices.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(invoices);
    }

    @PostMapping("")
    public ResponseEntity<Invoice> createInvoice(@RequestBody InvoiceCommand invoiceCommand) {
        return ResponseEntity.ok(invoiceService.createInvoice(invoiceCommand));
    }
}
