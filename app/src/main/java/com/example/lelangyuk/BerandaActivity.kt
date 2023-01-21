package com.example.lelangyuk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lelangyuk.View.ProdukListAdapter
import com.example.lelangyuk.ViewModel.ListViewModel
import com.example.lelangyuk.databinding.ActivityBerandaBinding
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_beranda.*

class BerandaActivity : AppCompatActivity() {
    lateinit var beranda_binding: ActivityBerandaBinding
    lateinit var viewModel: ListViewModel
    private  val produkListAdapter = ProdukListAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_beranda)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.fetchData()

        rv_list.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = produkListAdapter
        }
        observeViewModel()


    }

    fun observeViewModel(){
        viewModel.produkBody.observe(this, Observer{ produks ->
            produks?.let{
                produkListAdapter.updatePhotos(it)
            }
        })
    }

}