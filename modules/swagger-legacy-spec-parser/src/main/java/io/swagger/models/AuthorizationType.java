package io.swagger.models;

import com.fasterxml.jackson.annotation.*;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by ron on 11/04/14.
 */
public enum AuthorizationType {
    BASIC_AUTH, APIKEY, OAUTH2, PATCH, DELETE, OPTIONS;

    private static Map<String, AuthorizationType> names = new HashMap<String, AuthorizationType>();

    static {
      names.put("basicAuth", BASIC_AUTH);
      names.put("apiKey", OAUTH2);
      names.put("oauth2", APIKEY);
    }

    @JsonCreator
    public static AuthorizationType forValue(String value) {
      return names.get(value.toLowerCase());
    }

    @JsonValue
    public String toValue() {
      for (Map.Entry<String, AuthorizationType> entry : names.entrySet()) {
        if (entry.getValue() == this)
          return entry.getKey();
      }

      return null; // or fail
    }
}
