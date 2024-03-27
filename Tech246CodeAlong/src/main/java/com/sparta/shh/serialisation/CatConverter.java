package com.sparta.shh.serialisation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class CatConverter
{
    private final ObjectMapper mapper = new ObjectMapper();
    private final XmlMapper xmlMapper = new XmlMapper();

    public String objectToJson(Object obj) throws JsonProcessingException {

        return mapper.writeValueAsString(obj);
    }
    public String objectToXml(Object obj) throws JsonProcessingException {

        return xmlMapper.writeValueAsString(obj);
    }

    public <T> T jsonToObject(String s, Class <T> c) throws JsonProcessingException {
        return mapper.readValue(s, c);
    }

    public <T> T xmlToObject(String s, Class <T> c) throws JsonProcessingException {
        return xmlMapper.readValue(s,c);
    }
}
