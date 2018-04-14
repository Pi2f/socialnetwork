package com.polytech.persistence;

import com.polytech.services.User;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUserRepository implements UserRepository{
    private DataSource dataSource;

    public JDBCUserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(User user) {
        String query1 = "INSERT INTO users VALUES('"+user.getUsername()+"','"+user.getPassword()+"',"+user.isEnabled()+")";
        String query2 = "INSERT INTO users VALUES('"+user.getUsername()+"','ADMIN')";
        try {
            Statement statement = dataSource.getConnection().createStatement();
            statement.execute(query1);
            statement.execute(query2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
