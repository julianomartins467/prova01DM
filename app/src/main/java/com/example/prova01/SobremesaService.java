package com.example.prova01;

import java.util.List;

import retrofit2.Call;

public interface SobremesaService {
   Call<List<Sobremesa>> buscaSobremesas();
}
