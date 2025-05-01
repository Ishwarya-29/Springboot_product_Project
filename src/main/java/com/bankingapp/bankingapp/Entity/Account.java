package com.bankingapp.bankingapp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Account {

    @Id

    @GeneratedValue(generator = "custom-id")

    @GenericGenerator(name = "custom-id", strategy = "com.bankingapp.bankingapp.util.CustomIdGenerator")

    private Long id;
    private String acHolderName;
    private double balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcHolderName() {
        return acHolderName;
    }

    public void setAcHolderName(String acHolderName) {
        this.acHolderName = acHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account() {

    }

    public Account(Long id, String acHolderName, double balance) {
        this.id = id;
        this.acHolderName = acHolderName;
        this.balance = balance;
    }
}
