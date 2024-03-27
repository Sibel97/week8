package com.sparta.shh.serialisation;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

//{"name":"Archie","dob":"2020-03-12","priority": 1}
//<Cat><name>Fred</name><dob>2008-11-12</dob><priority>2</priority></Cat>
public class SerialisationApp
{
    public static void main(String[] args) {
        Cat angel = new Cat ("Angel", LocalDate.of(2018,8,15),5);
        System.out.println("To String: " + angel);

        CatConverter catConverter = new CatConverter();
        String jsonAngel;
        Cat archie;
        Cat fred;

        try{
            jsonAngel = catConverter.objectToJson(angel);
            System.out.println(jsonAngel);
            System.out.println(catConverter.objectToXml(angel));
            archie = catConverter.jsonToObject("{\"name\":\"Archie\",\"dob\":\"2020-03-12\",\"priority\": 1}",Cat.class);
            fred = catConverter.xmlToObject("<Cat><name>Fred</name><dob>2008-11-12</dob><priority>2</priority></Cat>", Cat.class);
            Cat[] cats = {angel,archie,fred};

            var jsonStringCats = catConverter.objectToJson(cats);
            var xmlStringCats = catConverter.objectToXml(cats);
            System.out.println(jsonStringCats);
            System.out.println(xmlStringCats);

            var moreCatsFromJson = catConverter.jsonToObject(jsonStringCats,Cat[].class);
            var moreCatsFromXML = catConverter.xmlToObject(xmlStringCats, Cat[].class);

            ArrayList<Cat> moreCatsList = new ArrayList<>(Arrays.asList(moreCatsFromJson));

        }catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
