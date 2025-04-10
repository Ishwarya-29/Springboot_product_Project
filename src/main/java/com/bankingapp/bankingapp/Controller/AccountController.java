//package com.bankingapp.bankingapp.Controller;
//
//import com.bankingapp.bankingapp.Entity.Account;
//import com.bankingapp.bankingapp.Service.AccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.Map;
//import java.util.Optional;
//
//@RestController("/account")
//public class AccountController {
//    @Autowired
//    private AccountService accountService;
//
//    @PostMapping("/add")
//    public Account createAccount(@RequestBody Account account) {
//        return accountService.createAccount(account);
//    }
//
//    @DeleteMapping("{/id}")
//    public void deleteAccount(@PathVariable Long id) {
//        accountService.deleteById(id);
//    }
//
//    @GetMapping("getAllDetails")
//    public ArrayList<Account> fetchAllAccountDetails()
//    {
//        return (ArrayList<Account>) accountService.getAllAccount();
//    }
//
//    @GetMapping("/getById/{id}")
//    public Optional<Account> getAccountDetailsById(@PathVariable Long id)
//    {
//        return accountService.getAccountById(id);
//    }
//    @PostMapping("/{id}/deposit")
//    public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
//        Double amount = request.get("amount");
//        return accountService.deposit(id, amount);
//    }
//
//    @PostMapping("/{id}/withdraw")
//    public Account withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
//        Double amount = request.get("amount");
//        return accountService.withdraw(id, amount);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Account> updateAccountDetails(@PathVariable Long id, @RequestBody Account updateRequest) {
//        Optional<Account> updatedAccount = accountService.updateAccountDetails(id, updateRequest);
//
//        if (updatedAccount.isPresent()) {
//            return ResponseEntity.ok(updatedAccount.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}


package com.bankingapp.bankingapp.Controller;

import com.bankingapp.bankingapp.Entity.Account;
import com.bankingapp.bankingapp.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @DeleteMapping("deleteAccount/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteById(id);
    }

    @GetMapping("/getAllDetails")
    public ArrayList<Account> fetchAllAccountDetails() {
        return (ArrayList<Account>) accountService.getAllAccount();
    }

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

    @PutMapping("updateDetails/{id}")
    public Account updateAccountDetails(@PathVariable Long id, @RequestBody Account updateRequest) {
        return accountService.updateAccountDetails(id, updateRequest);
    }
}