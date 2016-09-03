package com.example.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.domain.DbGroupPojo;

/**
 * Purpose: Maps a record in the ResultSet to a DbGroup object
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

public class GroupMapper implements RowMapper<DbGroupPojo>{
	public DbGroupPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
		DbGroupPojo group = new DbGroupPojo();
		group.setGroupID(rs.getInt("groupID"));
		group.setActive(rs.getInt("active"));
		group.setGroupName(rs.getString("groupName"));
		group.setUserID(rs.getInt("userID"));
		
		return group;
		
	}
}
