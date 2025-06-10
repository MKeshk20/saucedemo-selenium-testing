package com.example.utils;

import kong.unirest.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;

public class UserInfoFetcher {
    public static String[] getRandomUserInfo() {
        String json = Unirest.get("https://jsonplaceholder.typicode.com/users")
                .asString()
                .getBody();

        JSONArray users = new JSONArray(json);
        JSONObject randomUser = users.getJSONObject((int) (Math.random() * users.length()));

        String[] nameParts = randomUser.getString("name").split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[nameParts.length - 1];
        String postalCode = randomUser.getJSONObject("address").getString("zipcode");

        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Zip Code: " + postalCode);
        return new String[]{firstName, lastName, postalCode};
    }
}
