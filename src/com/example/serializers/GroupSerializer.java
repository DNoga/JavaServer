package com.example.serializers;

import java.lang.reflect.Type;

import com.example.domain.DbGroupPojo;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;

/**
 * Purpose: Interface for DbGroupPojoSerializer
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

public interface GroupSerializer {

	JsonElement serialize(DbGroupPojo dbGroup, Type type, JsonSerializationContext context);

}