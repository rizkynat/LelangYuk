package com.example.lelangyuk.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.lelangyuk.BASE_URL
import com.example.lelangyuk.Model.ProdukBody
import com.example.lelangyuk.R
import kotlinx.android.synthetic.main.item_list.view.*

class ProdukListAdapter(var produk: ArrayList<ProdukBody>):
RecyclerView.Adapter<ProdukListAdapter.ViewHolder>(){
    fun updatePhotos(newPhotos: List<ProdukBody>){
        produk.clear()
        produk.addAll(newPhotos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder (parent: ViewGroup, p1: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
    )
    override fun getItemCount() = produk.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(produk[position])
    }

class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
    fun bind(produkBody: ProdukBody){
        val foto: ImageView = itemView.gambar_produk
        val requestOp = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
        itemView.nama_produk.text = produkBody.nama_produk
        itemView.tv_kategori.text = produkBody.kategori
        itemView.tv_harga.text = "Rp."+produkBody.harga_dasar
        itemView.tv_jadwal_lelang.text = produkBody.jadwal_open
        itemView.setOnClickListener{ view ->
            Toast.makeText(itemView.context,"Hello", Toast.LENGTH_LONG).show()
        }
        val alamaturl = produkBody.img_url
        Glide.with(itemView.context)
            .applyDefaultRequestOptions(requestOp)
            .load("${BASE_URL.STORAGE_URL}/produk/$alamaturl")
            .into(foto)
    }
}
}
