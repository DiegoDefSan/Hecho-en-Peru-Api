package com.ddefilippi.hecho_en_peru_trabalho_3.id_generator;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;
import java.util.stream.Stream;

public class IdGenerator implements IdentifierGenerator, Configurable {
    private String prefix;
    private static final int DIGIT_COUNT = 4;

    @Override
    public Serializable generate(
            SharedSessionContractImplementor session, Object obj)
            throws HibernateException {

        String query = String.format("select %s from %s",
                session.getEntityPersister(obj.getClass().getName(), obj)
                        .getIdentifierPropertyName(),
                obj.getClass().getSimpleName());

        Stream ids = session.createQuery(query).stream();



        Long max = ids.map(e -> e.toString().replace(prefix, ""))
                .mapToLong(e -> Long.parseLong((String) e))
                .max()
                .orElse(0L);

        return prefix + '-' + String.format("%0" + DIGIT_COUNT + "d", max+1);
    }

    @Override
    public void configure(Type type, Properties properties,
                          ServiceRegistry serviceRegistry) throws MappingException {
        prefix = properties.getProperty("prefix");
    }
}
