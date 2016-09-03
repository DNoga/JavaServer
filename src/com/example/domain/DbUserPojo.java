package com.example.domain;

/**
 * Purpose: Java class representing User table
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

public class DbUserPojo {
	private int id;
	private int active;
	private String userPw;
	private String userName;
	
public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
public void setId(int id) {
	this.id = id;
}
public int getId() {
	return id;
}

public int getActive() {
	return active;
}
public void setActive(int active) {
	this.active = active;
}
public String getUserPw() {
	return userPw;
}
public void setUserPw(String userPw) {
	this.userPw = userPw;
}


@Override
public String toString(){
    return "id="+id+", active= "+active+", user name= "+ userName;
}

}
