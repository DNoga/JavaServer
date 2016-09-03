package com.example.dao;

import java.util.List;

import javax.sql.DataSource;

import com.example.domain.DbGroupPojo;

/**
 * Purpose: Interface for DbGroupDAOImpl
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

public interface DbGroupDAO {
	/** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource ds);
	   /** 
	    * This is the method to be used to create
	    * a record in the User table.
	    */
	   public void create(int groupID, String groupName, 
			   int userID, int active);
	   /** 
	    * This is the method to be used to list down
	    * a record from the User table corresponding
	    * to a passed user id.
	    */
	   public DbGroupPojo getGroupName(int id);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the User table.
	    */
	   public List<DbGroupPojo> listGroups();
	   /** 
	    * This is the method to be used to delete
	    * a record from the User table corresponding
	    * to a passed user id.
	    */
	   public void delete(int id);
	   /** 
	    * This is the method to be used to update
	    * a record into the User table.
	    */
	   public void update(int groupID, String groupName, 
	   int userID, int active);
}
