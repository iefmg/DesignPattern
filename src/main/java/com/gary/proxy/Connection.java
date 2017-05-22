package com.gary.proxy;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;

/**
 * @author gefengming
 *
 * @date 17/5/20
 */
public interface Connection extends Wrapper{

    Statement createStatement() throws SQLException;

    void close() throws SQLException;

}
