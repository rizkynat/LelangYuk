package com.example.lelangyuk

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lelangyuk.Model.ApiInterface
import com.example.lelangyuk.Model.LoginBody
import com.example.lelangyuk.Model.RegisterBody
import com.example.lelangyuk.Model.RetrofitInstance
import com.example.lelangyuk.Session.SessionManager
import com.example.lelangyuk.databinding.FragmentLoginAcitvityBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.ResponseBody
import retrofit2.Response



class LoginAcitvity : Fragment() {
    private lateinit var binding: FragmentLoginAcitvityBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login_acitvity, container, false)
        binding = FragmentLoginAcitvityBinding.bind(view)
        val email = binding.etEmailUser.text
        val password = binding.etPassword.text
        init()
        binding.btnMasuk.setOnClickListener(){
            signin  (email.toString(), password.toString())
            Log.i("Data Login", "Isi: "+email.toString()+password.toString())
        }

        binding.tvDaftarAkun.setOnClickListener(){
            findNavController().navigate(R.id.action_loginAcitvity_to_registerFragment)
        }



        return view
    }

    private fun init(){
        val sessionManager = SessionManager(this.context)
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
                    Toast.makeText(context,  "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun signin(email: String, password: String){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val signInInfo = LoginBody(email, password)
        retIn.login(signInInfo).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    context,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onResponse(call: retrofit2.Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 200) {
                    Toast.makeText(context, "Login success!", Toast.LENGTH_SHORT).show()
                    val sessionManager = SessionManager(context)
                    sessionManager.setLoggin(true)
                    sessionManager.setEmail(email)
                    val intent = Intent(context, BerandaActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(context, "Login failed!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }






}