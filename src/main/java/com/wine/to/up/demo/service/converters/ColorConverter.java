package com.wine.to.up.demo.service.converters;

import com.wine.to.up.demo.service.domain.enums.Color;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class ColorConverter implements UserType {

    private static final int[] SQL_TYPES = new int[]{Types.OTHER};

    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    @Override
    public Class returnedClass() {
        return null;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {
        return false;
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return 0;
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        Object pgObject = null;
        try {
            pgObject = resultSet.getObject("color");
        } catch (Exception e) {
            return null;
        }
        try {
            Method valueMethod = pgObject.getClass().getMethod("getValue");
            String value = (String) valueMethod.invoke(pgObject);
            return Color.valueOf(value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        if (value != null) {
            String v = ((Color) value).name().toLowerCase();
            st.setObject(
                    index,
                    v,
                    Types.OTHER
            );
        } else {
            st.setObject(
                    index,
                    null,
                    Types.OTHER
            );
            ;
        }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        return o;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return null;
    }


}