package com.example.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DbGroupDAO;
import com.example.domain.DbGroupPojo;
import com.example.mappers.GroupMapper;

/**
 * Purpose: Interaction between database and DbGroupPojo
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

public class DbGroupDAOImpl implements DbGroupDAO{
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private SessionFactory sessionFactory;
	
	public DbGroupDAOImpl() {
		
	}
	public DbGroupDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void create(int groupID, String groupName, int userID, int active) {
		String SQL = "INSERT INTO USER_GROUP (GROUPID, GROUPNAME, USERID, GROUPACTIVE) values (?, ?, ?, ?)";

		jdbcTemplateObject.update(SQL, groupID, groupName, userID, active);
		System.out.println(
				"Created Record Group Name = " + groupName  + " GROUP ID: " + groupID + ".");
		return;
		
	}

	@Override
	public DbGroupPojo getGroupName(int groupID) {
		String SQL = "SELECT * FROM USER_GROUP WHERE GROUPID = ?";
		DbGroupPojo group = jdbcTemplateObject.queryForObject(SQL, new Object[] { groupID }, new GroupMapper());
		return group;
		
	}

	@Override
	@Transactional
	public List<DbGroupPojo> listGroups() {
		 @SuppressWarnings("unchecked")
	        List<DbGroupPojo> listGroups = (List<DbGroupPojo>) sessionFactory.getCurrentSession()
	                .createCriteria(DbGroupPojo.class)
	                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	 
	        return listGroups;
	}

	@Override
	public void delete(int groupID) {
		String SQL = "DELETE FROM USER_GROUP WHERE GROUPID = ?";
		jdbcTemplateObject.update(SQL, groupID);
		System.out.println("Deleted Record with group ID = " + groupID);
		return;
		
	}

	@Override
	public void update(int groupID, String groupName, int userID, int active) {
		String SQL = "UPDATE USER_GROUP SET GROUPNAME = ? where GROUPID = ?";
		jdbcTemplateObject.update(SQL, groupName, groupID);
		SQL = "UPDATE USER_GROUP SET USERID = ? where GROUPID = ?";
		jdbcTemplateObject.update(SQL, userID, groupID);
		SQL = "UPDATE USER_GROUP SET GROUPACTIVE = ? where GROUPID = ?";
		jdbcTemplateObject.update(SQL, active, groupID);
		System.out.println("Updated Record with GROUP ID = " + groupID);
		
		return;
		
	}

}
