package com.epam.smailova.travel.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnPool {
    private BlockingQueue<Connection> connectionQueue;
    public ConnPool(final int POOL_SIZE) throws SQLException{
        connectionQueue=new ArrayBlockingQueue<Connection>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            Connection connection=

        }
    }
}
