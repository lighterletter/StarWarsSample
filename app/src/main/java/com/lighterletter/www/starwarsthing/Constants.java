package com.lighterletter.www.starwarsthing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * https://swapi.co/api/people/?format=json&page=1
 */

public class Constants {

    public final static String jsonSample = "{\n" +
            "name: \"Luke Skywalker\",\n" +
            "height: \"172\",\n" +
            "mass: \"77\",\n" +
            "hair_color: \"blond\",\n" +
            "skin_color: \"fair\",\n" +
            "eye_color: \"blue\",\n" +
            "birth_year: \"19BBY\",\n" +
            "gender: \"male\",\n" +
            "homeworld: \"https://swapi.co/api/planets/1/\",\n" +
            "films: [\n" +
            "\"https://swapi.co/api/films/2/\",\n" +
            "\"https://swapi.co/api/films/6/\",\n" +
            "\"https://swapi.co/api/films/3/\",\n" +
            "\"https://swapi.co/api/films/1/\",\n" +
            "\"https://swapi.co/api/films/7/\"\n" +
            "],\n" +
            "species: [\n" +
            "\"https://swapi.co/api/species/1/\"\n" +
            "],\n" +
            "vehicles: [\n" +
            "\"https://swapi.co/api/vehicles/14/\",\n" +
            "\"https://swapi.co/api/vehicles/30/\"\n" +
            "],\n" +
            "starships: [\n" +
            "\"https://swapi.co/api/starships/12/\",\n" +
            "\"https://swapi.co/api/starships/22/\"\n" +
            "],\n" +
            "created: \"2014-12-09T13:50:51.644000Z\",\n" +
            "edited: \"2014-12-20T21:17:56.891000Z\",\n" +
            "url: \"https://swapi.co/api/people/1/\"\n" +
            "}";

    /**
     * Sample of how you would create a json object.
     *
     * @return
     */
    public String getLukeJSON(){
        JSONObject luke = new JSONObject();
        try {
            luke.put("name","Luke Skywalker");
            luke.put("height","172");
            luke.put("mass","77");
            luke.put("films", new JSONArray()
                    .put("string 1")
                    .put("string 2")
                    .put("string 3"));
            luke.put("species",
                    new JSONArray()
                            .put("human"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return luke.toString();
    }

}
