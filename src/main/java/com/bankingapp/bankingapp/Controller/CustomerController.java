package com.bankingapp.bankingapp.Controller;

import com.bankingapp.bankingapp.Entity.Account;
import com.bankingapp.bankingapp.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/getById/{id}")
    public Account getAccountDetailsById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/deposit/{id}")
    public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.deposit(id, amount);
    }

    @PostMapping("/withdraw/{id}")
    public Account withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.withdraw(id, amount);
    }
}
