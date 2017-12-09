package com.lighterletter.www.starwarsthing;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json = Constants.jsonSample;

        Person luke = parseStarWarsPerson(json);

        Log.d(TAG, "onCreate: person name: " + luke.getName());

    }

    /**
     * height
     * mass
     * hair_color
     * skin_color
     * eye_color
     * birth_year
     * gender
     * homeworld
     *
     * @param json
     * @return
     */
    private Person parseStarWarsPerson(String json) {
        Person person = new Person();

        try {
            JSONObject object = new JSONObject(json);

            //setting fields
            person.setName(getStringValueFromJson(object, "name"));
            person.setHeight(getStringValueFromJson(object, "height"));
            person.setMass(getStringValueFromJson(object, "mass"));
            person.setHair_color(getStringValueFromJson(object, "hair_color"));
            person.setSkin_color(getStringValueFromJson(object, "skin_color"));
            person.setEye_color(getStringValueFromJson(object, "eye_color"));
            person.setBirth_year(getStringValueFromJson(object, "birth_year"));
            person.setGender(getStringValueFromJson(object, "gender"));
            person.setHomeworld(getStringValueFromJson(object, "homeworld"));


            String[] films = getStringArrayFromJson(object, "films");
            person.setFilms(films);
            String[] species = getStringArrayFromJson(object, "species");
            person.setSpecies(species);
            String[] vehicles = getStringArrayFromJson(object, "vehicles");
            person.setVehicles(vehicles);
            String[] starships = getStringArrayFromJson(object, "starships");
            person.setStarships(starships);

            person.setCreated(getStringValueFromJson(object, "created"));
            person.setEdited(getStringValueFromJson(object, "edited"));
            person.setUrl(getStringValueFromJson(object, "url"));


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return person;
    }

    @NonNull
    private String[] getStringArrayFromJson(JSONObject object, String key) throws JSONException {
        JSONArray jsonArray = object.getJSONArray(key);
        String[] strings = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            strings[i] = (String) jsonArray.get(i);
        }
        return strings;
    }

    private String getStringValueFromJson(JSONObject object, String key) throws JSONException {
        return object.getString("name");
    }
}
