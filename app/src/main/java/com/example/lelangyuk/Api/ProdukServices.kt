package com.example.lelangyuk.Api

import com.example.lelangyuk.Model.ApiInterface
import com.example.lelangyuk.Model.ProdukBody
import com.example.lelangyuk.Model.RetrofitInstance
import io.reactivex.Single

class ProdukServices {
    fun getProduks():Single<List<ProdukBody>>{
        val api: ApiInterface
        api = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        return api.getProduks()
    }
}