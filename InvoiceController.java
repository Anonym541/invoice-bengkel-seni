package com.bengkel_seni.invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bengkel_seni.invoice.model.Invoice;
import com.bengkel_seni.invoice.repository.InvoiceRepository;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceRepository repo;

    @GetMapping("/")
    public String index(Model model) {
        // Ambil semua riwayat untuk ditampilkan di tabel bawah
        model.addAttribute("invoices", repo.findAll());
        return "index";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Invoice invoice) {
        // Simpan ke database
        repo.save(invoice);
        // Kembali ke halaman utama agar data baru muncul di tabel
        return "redirect:/";
    }

    @GetMapping("/cetak/{id}")
    public String cetak(@PathVariable Long id, Model model) {
        // Ambil data spesifik berdasarkan ID untuk dicetak
        Invoice inv = repo.findById(id).orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
        model.addAttribute("inv", inv);
        return "nota";
    }
}