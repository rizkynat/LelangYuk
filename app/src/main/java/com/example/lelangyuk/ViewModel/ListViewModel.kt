package com.example.lelangyuk.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lelangyuk.Api.ProdukService
import com.example.lelangyuk.Api.ProdukServices
import com.example.lelangyuk.Model.ProdukBody
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel: ViewModel() {
    private val produkService = ProdukService()
    private val disposable = CompositeDisposable()
    val produkBody = MutableLiveData<List<ProdukBody>>()

    fun fetchData() {
        disposable.add(
            produkService.getProduks()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<ProdukBody>>() {
                    override fun onSuccess(value: List          <ProdukBody>?) {
                        produkBody.value = value
                        Log.i("Data:", value.toString())
                    }

                    override fun onError(e: Throwable?) {
                        Log.e("ERRORFETCHDATA", "error$e")
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}