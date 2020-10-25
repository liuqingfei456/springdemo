package com.weiyi.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql="insert into im_setting_sensitive (sensitive_keyword) values (?)";
        jdbcTemplate.update(sql,"对不起");
    }
}
