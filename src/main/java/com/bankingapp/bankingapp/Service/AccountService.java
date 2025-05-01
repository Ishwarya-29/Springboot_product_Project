package com.bankingapp.bankingapp.Service;

import com.bankingapp.bankingapp.Entity.Account;
import com.bankingapp.bankingapp.Exception.InsufficientBalanceException;
import com.bankingapp.bankingapp.Exception.ResourceNotFoundException;
import com.bankingapp.bankingapp.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));
        return account;
    }

    public List<Account> getAllAccount() {
        return (ArrayList<Account>) accountRepository.findAll();
    }


    public void deleteById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));
        accountRepository.delete(account);


    }

    public Account updateAccountDetails(Long id, Account updateRequest) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));

        account.setAcHolderName(updateRequest.getAcHolderName());
        return accountRepository.save(account);

    }

    public Account deposit(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    public Account withdraw(Long id, Double amount) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));

        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal");
        }

        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }

}
