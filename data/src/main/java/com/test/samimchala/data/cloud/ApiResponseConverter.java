package com.test.samimchala.data.cloud;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.samimchala.data.model.ApiResponse;
import com.test.samimchala.domain.entities.WindForecast;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;


public class ApiResponseConverter implements Converter {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public Object fromBody(TypedInput body, Type type) throws ConversionException {
        JavaType javaType = mapper.getTypeFactory().constructType(type);

        try {
            ApiResponse apiResponse = mapper.readValue(body.in(), javaType);
            WindForecast windForecast = new WindForecast();
            windForecast.setCountry(apiResponse.getSys().getCountry());
            windForecast.setDate(apiResponse.getDt());
            windForecast.setName(apiResponse.getName());
            windForecast.setId(apiResponse.getId());
            windForecast.setSpeed(apiResponse.getWind().getSpeed());
            windForecast.setDegree(apiResponse.getWind().getDeg());

            return windForecast;
        } catch (IOException e) {
            throw new ConversionException(e);
        }
    }

    @Override
    public TypedOutput toBody(Object object) {
        try {
            String charset = "UTF-8";
            String json = mapper.writeValueAsString(object);
            return new JsonTypedOutput(json.getBytes(charset));
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private static class JsonTypedOutput implements TypedOutput {
        private final byte[] jsonBytes;

        JsonTypedOutput(byte[] jsonBytes) { this.jsonBytes = jsonBytes; }

        @Override public String fileName() { return null; }
        @Override public String mimeType() { return "application/json; charset=UTF-8"; }
        @Override public long length() { return jsonBytes.length; }
        @Override public void writeTo(OutputStream out) throws IOException { out.write(jsonBytes); }
    }
}