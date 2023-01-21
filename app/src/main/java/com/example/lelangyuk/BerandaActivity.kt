package com.example.lelangyuk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        beranda_binding = ActivityBerandaBinding.inflate(layoutInflater)
        setContentView(beranda_binding.root)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.fetchData()

        rv_list.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = produkListAdapter
        }
        observeViewModel()

        beranda_binding.navigationView.setOnItemReselectedListener { item ->
            when(item.itemId){
                R.id.favorite -> {
                    //startActivity(Intent(baseContext, LoginAcitvity::class.java))
                    Toast.makeText(this, "Hai ini favorite", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.search -> {
                    //startActivity(Intent(baseContext, LoginAcitvity::class.java))
                    Toast.makeText(this, "Hai ini search", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.lelang -> {
                //startActivity(Intent(baseContext, LoginAcitvity::class.java))
                Toast.makeText(this, "Hai ini lelang", Toast.LENGTH_SHORT).show()
                true
                }
                R.id.akun -> {
                //startActivity(Intent(baseContext, LoginAcitvity::class.java))
                Toast.makeText(this, "Hai ini akun", Toast.LENGTH_SHORT).show()
                true
                }
                else -> {
                    throw IllegalAccessException("ada yang salah")
                }
            }
        }

    }

    fun observeViewModel(){
        viewModel.produkBody.observe(this, Observer{ produks ->
            produks?.let{
                produkListAdapter.updatePhotos(it)
            }
        })
    }

}