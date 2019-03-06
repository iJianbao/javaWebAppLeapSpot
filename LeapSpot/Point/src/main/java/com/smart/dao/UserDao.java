package com.smart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName, String password) {
        String sqlStr = " select count(*) from t_user " + " where user_name=? and password=? ";
        int count = jdbcTemplate.queryForObject(sqlStr, new Object[] {userName, password}, int.class);

        return count;
    }

    public User findUserByUserName(final String userName) {
        String sqlStr = " select user_id, user_name from t_user " + " where user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
            }
        });

        return user;
    }

    public void updateLoginInfo(User user) {
        String sqlStr = " update t_user sel last_visit=?, last_ip=? " + " where user_id=? ";
        jdbcTemplate.update(sqlStr, new Object[] { user.getLastVisit(), user.getLastIp(), user.getUserId() });
    }

    public User getUserByUserId(final String userId) {
        String sqlStr = " select user_id, user_name from t_user " + " where user_id = ?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userId}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
            }
        });
        return user;
    }
}
