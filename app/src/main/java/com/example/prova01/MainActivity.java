package com.example.prova01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private MyAdapter myAdapter;
    private RecyclerView myRecyclerView;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SobremesaService service = RetrofitClient.getRetrofitInstance().create(SobremesaService.class);

        Call<List<Sobremesa>> callArray = service.buscaSobremesas();

        callArray.enqueue(new Callback<List<Sobremesa>>()
        {
            @Override
            public void onResponse(Call<List<Sobremesa>> call, Response<List<Sobremesa>> response) {
                loadDataList(response.body());
               // if (response.isSuccessful())
               // {
              //      List<Sobremesa> sobremesas = response.body();
               // }
            }

            @Override
            public void onFailure(Call<List<Sobremesa>> call, Throwable t) {
                Log.e("Enqueue", t.getLocalizedMessage());
                Toast.makeText(MainActivity.this, "Erro ao carrega sobremesas", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loadDataList(List<Sobremesa> usersList) {
        myRecyclerView = findViewById(R.id.myRecyclerView);
        myAdapter = new MyAdapter(usersList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);

        myRecyclerView.setAdapter(myAdapter);
    }
}