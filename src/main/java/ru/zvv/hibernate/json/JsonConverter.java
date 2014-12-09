package ru.zvv.hibernate.json;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by z-ghost on 08.12.2014.
 */
public class JsonConverter {
    private ObjectMapper objectMapper;

    public JsonConverter()
    {
        objectMapper = new ObjectMapper()
                .configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, false)
                .configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationConfig.Feature.USE_ANNOTATIONS, true)
                .enableDefaultTyping(ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    }

    public Object fromJson(String json, Class type) {
        try
        {
            return objectMapper.readValue(json, type);

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }

    public String toJson(Object value) {
        try
        {
            return objectMapper.writeValueAsString(value);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }
}
