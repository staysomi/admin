package com.example.admin.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Data {
    public static String[] data_login = {"admin", "mogan"};
    public static String[] barang = {"karbu", "velg", "piston", "spedometer"};
    public static String[] karbu = {"PE", "PWK", "PWL", "PWM"};
    public static String[] velg = {"17", "18", "19", "20"};
    public static String[] piston = {"70", "71", "72", "73"};
    public static String[] spedometer = {"KOSO", "BABON", "VIXION", "BULAT"};
    public static JSONObject json;

    static {
        try {
            json = new JSONObject()
                    .put("karbu",
                            new JSONArray()
                                    .put(new JSONObject().put("id", 1).put("name", "pwk").put("price", "10000"))
                                    .put(new JSONObject().put("id", 2).put("name", "pe").put("price", "100000"))
                    )
                    .put("velg",
                            new JSONArray()
                                    .put(new JSONObject().put("id", 1).put("name", "ring 17").put("price", "10000"))
                                    .put(new JSONObject().put("id", 2).put("name", "ring 18").put("price", "100000"))
                    );
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
