package com.wine.to.up.catalog.service.converters;

import com.wine.to.up.catalog.service.domain.enums.Sugar;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class SugarConverter implements UserType {

    private static final int[] SQL_TYPES = new int[]{Types.OTHER};

    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    @Override
    public Class returnedClass() {
        return Sugar.class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {
        //return o.equals(o1);
        return true;
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        Object pgObject = null;
        String trueName = "sugar";
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            String nameColumn = resultSet.getMetaData().getColumnName(i);
            if (nameColumn.contains("sugar")) {
                trueName = nameColumn;
                break;
            }
        }

        try {
            pgObject = resultSet.getObject(trueName);
        } catch (Exception e) {
            return null;
        }
        try {
            return Sugar.valueOf(((String) pgObject).toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        if (value != null) {
            String v = ((Sugar) value).name().toUpperCase();
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
        if (o == null) {
            return o1;
        } else {
            return o;
        }
    }

}
