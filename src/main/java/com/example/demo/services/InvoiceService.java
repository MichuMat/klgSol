package com.example.demo.services;

import com.example.demo.commands.InvoiceCommand;
import com.example.demo.entities.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getInvoices(String customerName);

    Invoice createInvoice(InvoiceCommand invoiceCommand);
}
