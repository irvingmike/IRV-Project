package com.irvingmichael.irv.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Aaron Anderson on 11/8/16.
 */
public class Experiments {

    @Test
    public void buildingPoll() {
        String json = "{\"title\":\"TestTile\",\"description\":\"This is a test description.\",\"choices\":[\"Choice 1\",\"Choice 2\",\"Choice 3\"]}";
        Gson gson = new Gson();
        JsonObject jsonObj = gson.fromJson(json, JsonObject.class);
        System.out.println(jsonObj.get("title"));
        JsonArray choices = jsonObj.getAsJsonArray("choices");
        for (JsonElement choice : choices) {
            System.out.println(choice.getAsString());
        }
    }
}
