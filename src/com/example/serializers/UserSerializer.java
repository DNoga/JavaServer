package com.example.serializers;

import java.lang.reflect.Type;

import com.example.domain.DbUserPojo;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;

/**
 * Purpose: Interface for DbUserPojoSerializer
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

public interface UserSerializer {

	JsonElement serialize(DbUserPojo dbUser, Type type, JsonSerializationContext context);

}