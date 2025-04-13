package com.libary.libary.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

public class CustomUserIdGenerator implements IdentifierGenerator, Serializable {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        Random random = new Random();
        long id = 0;
        for (int i = 0; i < 5; i++) {
            id = id * 10 + random.nextInt(10);
        }
        return id;
    }
}
