package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            json();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Handler handler = new Handler();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        handler.postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                    }
                }, 3000
        );
    }

    public void json() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("karbu",
                new JSONArray()
                        .put(new JSONObject().put("id", 1).put("name", "pwk").put("price", "10000"))
                        .put(new JSONObject().put("id", 2).put("name", "pe").put("price", "100000"))
        );
        json.put("velg",
                new JSONArray()
                        .put(new JSONObject().put("id", 1).put("name", "ring 17").put("price", "10000"))
                        .put(new JSONObject().put("id", 2).put("name", "ring 18").put("price", "100000"))
        );
        Log.d("TAG", "json: " + json);
    }
}