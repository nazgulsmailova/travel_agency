package com.epam.smailova.travel.dao;

import com.epam.smailova.travel.model.BaseEntity;

import java.sql.Connection;

public abstract class JdbcDao<T extends BaseEntity> implements Dao<T> {

    // static final Logger LOG = Logger.getLogger(DaoI.class);
    private Connection connection;

    protected JdbcDao(Connection connection) {
        this.connection = connection;
    }

    public JdbcDao() {
    }

    public void setConnection(Connection connection){
        this.connection=connection;
    }

    /*public void close(Statement statement){
        try {
            if (statement!=null){
                statement.close();
            }
        }catch (SQLException e){
            LOG.error(e);
        }
    }
    public void close(Connection connection){
        try {
            if (connection!=null){
                connection.close();
            }
        }catch (SQLException e){

        }
    }*/
}
