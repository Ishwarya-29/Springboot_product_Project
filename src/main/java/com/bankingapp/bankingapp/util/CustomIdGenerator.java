package com.bankingapp.bankingapp.util;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator, Serializable {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        Random random = new Random();
        long id = 0;
        for (int i = 0; i < 12; i++) {
            id = id * 10 + random.nextInt(10);
        }
        return id;
    }
}
