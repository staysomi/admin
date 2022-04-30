package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.data.Data;

public class DetailItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        String nama_barang = getIntent().getStringExtra("nama");
        ListView listView = findViewById(R.id.list_item_detail);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item, type(nama_barang)
        );
        listView.setAdapter(arr);
    }

    private String[] type(String value) {
        switch (value) {
            case "karbu":
                return Data.karbu;
            case "velg":
                return Data.velg;
            case "piston":
                return Data.piston;
            case "spedometer":
                return Data.spedometer;
        }
        return null;
    }
}
