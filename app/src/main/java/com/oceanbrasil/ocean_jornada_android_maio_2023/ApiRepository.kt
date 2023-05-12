package com.oceanbrasil.ocean_jornada_android_maio_2023

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRepository {
    init {
        // Prepara o Retrofit para ser usado
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.airtable.com/v0/appouUwOyyKLH6Eyz/")
            .addConverterFactory(GsonConverterFactory.create())
            // TODO: Implementar Autorização
            .build()

        // Prepara o HintsService para ser usado, a partir do retrofit
        val hintsService = retrofit.create(HintsService::class.java)

        // Cria a chamada que irá ser executada para listar as dicas que estão na API
        val call = hintsService.listHints()

        // Realiza a chamada para obter a lista de dicas
        call.enqueue(object : Callback<HintsApiResult> {
            // Em caso de sucesso, traz a resposta no `onResponse`
            override fun onResponse(
                call: Call<HintsApiResult>,
                response: Response<HintsApiResult>
            ) {
                // Podemos utilizar a informação contida em `response` para ter
                // os resultados
                Log.d("API_REPOSITORY", "Resposta recebida com sucesso!")
            }

            // Em caso de falha, traz o erro para o `onFailure`
            override fun onFailure(call: Call<HintsApiResult>, t: Throwable) {
                // Podemos utilizar a informaçõa contida em `t` para saber
                // qual foi o erro
                Log.e("API_REPOSITORY", "Resposta falhou!", t)
            }
        })
    }
}
