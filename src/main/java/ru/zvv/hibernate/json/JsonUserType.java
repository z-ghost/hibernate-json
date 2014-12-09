package ru.zvv.hibernate.json;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by z-ghost on 08.12.2014.
 */
public class JsonUserType implements UserType {
    private JsonConverter converter = new JsonConverter();

    private Class entityClass;

    public JsonUserType(Class entity)
    {
        this.entityClass = entity;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return converter.fromJson((String) cached, entityClass);
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        if (value == null)
            return null;
        return converter.fromJson(converter.toJson(value), entityClass);
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return converter.toJson(value);
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == null) return (y != null);

        return (x.equals(y));
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor sessionImplementor, Object owner) throws HibernateException, SQLException {
        String value = rs.getString(names[0]);
        if (!rs.wasNull()) {
            return converter.fromJson(value, entityClass);
        }

        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor sessionImplementor) throws HibernateException, SQLException {

        if (value == null) {
            st.setNull(index, Types.LONGNVARCHAR);
        } else {
            st.setString(index, converter.toJson(value));
        }

    }


    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return deepCopy(original);
    }

    @Override
    public Class returnedClass() {
        return Object.class;
    }

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.LONGVARCHAR};
    }

}
