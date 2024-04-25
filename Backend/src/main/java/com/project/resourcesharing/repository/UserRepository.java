package com.project.resourcesharing.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.project.resourcesharing.model.User;

import io.micrometer.common.lang.Nullable;

@Repository
public class UserRepository {
    
@Autowired
JdbcTemplate jdbcTemplate;
    
    public List<User> getAllUsers() {
        String sql = "Select * from  users";


        return jdbcTemplate.query(sql, new RowMapper<User>() {

            @Override
            @Nullable
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User c = new User();
                c.setUserId(rs.getString("userId"));
                c.setUserName(rs.getString("userName"));
                c.setEmail(rs.getString("email"));
                c.setPassword(rs.getString("password"));
                c.setStreet(rs.getString("street"));
                c.setState(rs.getString("state"));
                c.setCounty(rs.getString("county"));
                c.setAptNo(rs.getString("aptNo"));
                c.setPinCode(rs.getString("pinCode"));
                    return c;
            }
            
        });
    }

    public Integer findByUserId(String userId) {

        String sql = "Select count(*) from  users where userId = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,userId);
    }

    public Integer findByUserEmail(String email) {

        String sql = "Select count(*) from  users where email = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,email);
    }



    public User findUserById(String userId) {

        String sql = "Select * from  users where userId = ?";
        System.out.println(userId);
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(User.class));
    }


    public Integer addUser(User user) {
        System.out.println("inside adduser");
        String sql = "INSERT INTO users (userId, userName, email, password, street, state, county, aptNo, pinCode) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
        user.getUserId(),
        user.getUserName(),
        user.getEmail(),
        user.getPassword(), 
        user.getStreet(),
        user.getState(),
        user.getCounty(),
        user.getAptNo(),
        user.getPinCode());
    }

 
    public Integer updateUser(User user){
        String sql = "UPDATE users SET "
                   + "userName = ?, "
                   + "email = ?, "
                   + "password = ?, "
                   + "street = ?, "
                   + "state = ?, "
                   + "county = ?, "
                   + "aptNo = ?, "
                   + "pinCode = ? "
                   + "WHERE userId = ?";

        return jdbcTemplate.update(sql, 
            user.getUserName(), 
            user.getEmail(), 
            user.getPassword(),
            user.getStreet(), 
            user.getState(), 
            user.getCounty(), 
            user.getAptNo(), 
            user.getPinCode(), 
            user.getUserId());
    }
    

}
