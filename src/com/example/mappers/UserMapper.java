package com.example.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.domain.DbUserPojo;

/**
 * Purpose: Maps a record in the ResultSet to a DbUser object
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

public class UserMapper implements RowMapper<DbUserPojo> {
	public DbUserPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
		DbUserPojo user = new DbUserPojo();
		user.setId(rs.getInt("id"));
		user.setActive(rs.getInt("active"));
		user.setUserName(rs.getString("userName"));
		user.setUserPw(rs.getString("userPw"));
		
		return user;
		
	}
}
