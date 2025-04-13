package com.libary.libary.util;

import com.libary.libary.entity.Book;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CustomBookIdGenerator implements IdentifierGenerator {
    private final Map<String, Integer> subjectCountMap;

    public CustomBookIdGenerator() {
        subjectCountMap = new HashMap<>();
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        // Assuming the object has a method getSubject() to get the subject
        String subject = ((Book) object).getSubject();
        return generateBookId(subject);
    }

    public String generateBookId(String subject) {
        String normalizedSubject = subject.toLowerCase();
        int count = subjectCountMap.getOrDefault(normalizedSubject, 0);
        count++;
        subjectCountMap.put(normalizedSubject, count);
        String prefix = normalizedSubject.substring(0, 3);
        return String.format("%s%04d", prefix, count);
    }
}
