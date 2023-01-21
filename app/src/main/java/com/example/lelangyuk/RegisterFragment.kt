package com.example.lelangyuk

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lelangyuk.Model.ApiInterface
import com.example.lelangyuk.Model.RegisterBody
import com.example.lelangyuk.Model.RetrofitInstance
import com.example.lelangyuk.databinding.FragmentRegisterBinding
import okhttp3.ResponseBody
import retrofit2.Response


class RegisterFragment : Fragment() {

    lateinit var et_nama_lengkap : EditText
    lateinit var et_email : EditText
    lateinit var et_password : EditText
    lateinit var btn_daftar : Button
    lateinit var tv_masuk : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        et_nama_lengkap = view.findViewById<EditText>(R.id.et_reg_nama_lengkap)
        et_email = view.findViewById<EditText>(R.id.et_reg_email_user)
        et_password = view.findViewById<EditText>(R.id.et_reg_password)
        btn_daftar = view.findViewById<Button>(R.id.btn_daftar)
        tv_masuk = view.findViewById<TextView>(R.id.tv_masuk)

        tv_masuk.setOnClickListener(){
            findNavController().navigate(R.id.action_registerFragment_to_loginAcitvity)
        }


        btn_daftar.setOnClickListener(){
            singup(et_nama_lengkap.text.toString(), et_email.text.toString(), et_password.text.toString())
            //Toast.makeText(this@RegisterActivity, et_nama_lengkap, Toast.LENGTH_SHORT)
            Log.i("val", et_nama_lengkap.text.toString())
        }

        return view
    }


    private fun singup(nama_lengkap: String, email: String, password: String){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val registerInfo = RegisterBody(nama_lengkap, email, password)

        retIn.registerUser(registerInfo).enqueue(object :
            retrofit2.Callback<ResponseBody> {
            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    context,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(
                call: retrofit2.Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                if(response.code() == 201){
                    Toast.makeText(context,  "Registrasi "+et_nama_lengkap.text.toString()+" Berhasil!", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_registerFragment_to_loginAcitvity)
                }
            }
        })
    }

}