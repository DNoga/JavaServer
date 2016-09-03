package com.example.serializers;

import java.lang.reflect.Type;

import com.example.domain.DbUserPojo;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Purpose: Returns DbUser in JSON format
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */


public class DbUserPojoSerializer implements JsonSerializer<DbUserPojo>, UserSerializer{


	@Override
	public JsonElement serialize(final DbUserPojo dbUser, Type type, JsonSerializationContext context) {
		JsonObject result = new JsonObject();
		result.add("id", new JsonPrimitive(dbUser.getId()));
		result.add("active", new JsonPrimitive(dbUser.getActive()));
		result.add("userPw", new JsonPrimitive(dbUser.getUserPw()));
		result.add("userName", new JsonPrimitive(dbUser.getUserName()));
		
		return result;
	}

	
	
}
