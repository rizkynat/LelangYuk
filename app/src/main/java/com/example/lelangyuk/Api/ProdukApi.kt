package com.example.lelangyuk.Api

import com.example.lelangyuk.Model.ProdukBody
import io.reactivex.Single
import retrofit2.http.GET

interface ProdukApi {
    @GET("produk")
    fun getProduks(): Single<List<ProdukBody>>
}