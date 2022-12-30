package com.example.lelangyuk.vPagerFragment.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.lelangyuk.R
import com.example.lelangyuk.databinding.FragmentHalamanPertamaBinding

class HalamanPertama : Fragment() {
    private lateinit var binding : FragmentHalamanPertamaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //inflate layout for this fragment
        val view = inflater.inflate(R.layout.fragment_halaman_pertama, container, false)

        binding = FragmentHalamanPertamaBinding.bind(view)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnStart.setOnClickListener{
            viewPager?.currentItem = 1
        }

        return view
    }


}