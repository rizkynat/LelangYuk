package com.example.lelangyuk.Api

import com.example.lelangyuk.BASE_URL
import com.example.lelangyuk.Model.ProdukBody
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ProdukService {
    private val api: ProdukApi

    init {
        api = Retrofit.Builder()
            .baseUrl(BASE_URL.NGROK_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ProdukApi::class.java)
    }
    fun getProduks(): Single<List<ProdukBody>> {
        return api.getProduks()
    }
}