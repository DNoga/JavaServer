package com.example.serializers;

import java.lang.reflect.Type;

import com.example.domain.DbGroupPojo;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Purpose: Returns DbGroup in JSON format
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

public class DbGroupPojoSerializer implements JsonSerializer<DbGroupPojo>, GroupSerializer{


	@Override
	public JsonElement serialize(final DbGroupPojo dbGroup, Type type, JsonSerializationContext context) {
		JsonObject result = new JsonObject();
		result.add("groupID", new JsonPrimitive(dbGroup.getGroupID()));
		result.add("groupName", new JsonPrimitive(dbGroup.getGroupName()));
		result.add("userID", new JsonPrimitive(dbGroup.getUserID()));
		result.add("active", new JsonPrimitive(dbGroup.getActive()));
		
		return result;
	}



}
