package com.example.domain;

/**
 * Purpose: Java class representing UserGroup table
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

public class DbGroupPojo {
private int groupID;
private String groupName;
private int userID;
private int active;


public int getGroupID() {
	return groupID;
}
public void setGroupID(int groupID) {
	this.groupID = groupID;
}
public String getGroupName() {
	return groupName;
}
public void setGroupName(String groupName) {
	this.groupName = groupName;
}
public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
public int getActive() {
	return active;
}
public void setActive(int active) {
	this.active = active;
}

@Override
public String toString(){
    return "groupid="+groupID+", group name= " + groupName +", userID= "+userID+", active= "+active;
}

}
