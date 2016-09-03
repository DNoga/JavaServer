package com.example.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DbUserDAO;
import com.example.domain.DbUserPojo;
import com.example.mappers.UserMapper;

/**
 * Purpose: Interaction between database and DbUserPojo
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

public class DbUserDAOImpl implements DbUserDAO {
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private SessionFactory sessionFactory;
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public DbUserDAOImpl() {
		
	}
	public DbUserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(int id, String userPw, int active, String userName) {
		userPw = passwordEncoder.encode(userPw);
		String SQL = "INSERT INTO USER (ID,USERPW,ACTIVE,USERNAME) values (?, ?, ?, ?)";

		jdbcTemplateObject.update(SQL, id, userPw, active, userName);
		return;
	}

	public DbUserPojo getUser(int id) {
		String SQL = "SELECT * FROM USER WHERE ID = ?";
		DbUserPojo user = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new UserMapper());
		return user;
	}
	
	@Override
	@Transactional
	public List<DbUserPojo> listUsers() {
        @SuppressWarnings("unchecked")
        List<DbUserPojo> listUser = (List<DbUserPojo>) sessionFactory.getCurrentSession()
                .createCriteria(DbUserPojo.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
	}

	public void delete(int id) {
		String SQL = "DELETE FROM USER WHERE ID = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
		return;
	}

	public void update(int id, String userPw, int active, String userName) {
		String SQL = "UPDATE USER SET USERPW = ? where id = ?";
		jdbcTemplateObject.update(SQL, userPw, id);
		SQL = "UPDATE USER SET ACTIVE = ? where id = ?";
		jdbcTemplateObject.update(SQL, active, id);
		SQL = "UPDATE USER SET USERNAME = ? where id = ?";
		jdbcTemplateObject.update(SQL, userName, id);
		System.out.println("Updated Record with ID = " + id);
		return;

	}
}
