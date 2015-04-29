package com.epam.smailova.travel.dao;


import java.util.EnumMap;

public abstract class DaoFactory {
    static EnumMap<Type, DaoFactory> factories = new EnumMap<Type, DaoFactory>(Type.class);
    static {
        factories.put(Type.Jdbc, JdbcDaoFactory.getInstance());
    }

    public static DaoFactory getInstance(Type type) {
        return factories.get(type);
    }



    public enum Type {
        Jdbc, Xml, Mongo, Neo4j, Redis
    }
}
