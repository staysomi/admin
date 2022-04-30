package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.data.Data;
import com.example.admin.model.ListKarbu;
import com.example.admin.model.Model;
import com.example.admin.rest.RestAPI;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    String[] data_barang;
    String url = "C:\\Users\\Pepe\\Documents\\restapi\\data.html";

    private ListView listView;

    private List<ListKarbu> karb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String username = getIntent().getStringExtra("username");
        TextView status = (TextView) findViewById(R.id.statuslogin);
        status.setText("Hello " + username);

//        final ProgressDialog loading = ProgressDialog.show(this,"Fetching Data","Please Wait..",false,false);
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        //set Level Log
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        httpClient.addInterceptor(logging);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())//GsonConverter untuk parsing json
//                .client(httpClient.build())
//                .build();
//
//        RestAPI service = retrofit.create(RestAPI.class);
//
//        Call<Model> call = service.loadListKarbu();
//        call.enqueue(new Callback<Model>() {  //Asyncronous Request
//
//            @Override
//            public void onResponse(Call<Model> call, Response<Model> response) {
//                loading.dismiss();
//                List<ListKarbu> karbu = response.body().getListKarbu();
//
//                //memasukkan data dari varibel buku ke books
//                karb = karbu;
//                //memanggil method untuk menampilkan list
//                showList();
//            }
//
//            @Override
//            public void onFailure(Call<Model> call, Throwable t) {
//
//            }
//        });

        listView = findViewById(R.id.list_item);
        data_barang = Data.barang;
        JSONObject json = Data.json;
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                (List<String>) json);
        listView.setAdapter(arr);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = Arrays.asList(data_barang).get(i);

                Intent intent = new Intent(HomeActivity.this, DetailItem.class);
                intent.putExtra("nama", item);
                startActivity(intent);
            }
        });
    }
    private void showList() {
        //String array untuk menyimpan nama semua nama buku
        String[] items = new String[karb.size()];

        for (int i = 0; i < karb.size(); i++) {
            items[i] = karb.get(i).getNama();
        }
        //Membuat Array Adapter for listview
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, items);

        //setting adapter untuk listview
        listView.setAdapter(adapter);

    }

}