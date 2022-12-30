package com.example.lelangyuk.vPagerFragment.screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.lelangyuk.R
import com.example.lelangyuk.databinding.FragmentHalamanKeduaBinding

class HalamanKedua : Fragment() {

    private lateinit var binding: FragmentHalamanKeduaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_halaman_kedua, container, false)

        binding = FragmentHalamanKeduaBinding.bind(view)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnNext.setOnClickListener{
            findNavController().navigate(R.id.action_viewPagerFragment_to_halamanUtamaFragment)
        }
        return view
    }

    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor =sharedPref.edit()
        editor.putBoolean("Selesai", true)
        editor.apply()
    }

}