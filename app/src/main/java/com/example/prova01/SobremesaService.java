package com.example.prova01;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SobremesaService {
   @GET("droidcafe")
   Call<List<Sobremesa>> buscaSobremesas();
}
