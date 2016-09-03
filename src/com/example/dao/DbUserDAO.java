package com.example.dao;

import java.util.List;

import javax.sql.DataSource;

import com.example.domain.DbUserPojo;

/**
 * Purpose: Interface for DbUserDAOImpl
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

public interface DbUserDAO {
	/** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource ds);
	   /** 
	    * This is the method to be used to create
	    * a record in the User table.
	    */
	   public void create(int id, String userPw, int active, String userName);
	   /** 
	    * This is the method to be used to list down
	    * a record from the User table corresponding
	    * to a passed user id.
	    */
	   public DbUserPojo getUser(int id);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the User table.
	    */
	   public List<DbUserPojo> listUsers();
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
	   public void update(int id, String userPw, int active, String userName);
	}

