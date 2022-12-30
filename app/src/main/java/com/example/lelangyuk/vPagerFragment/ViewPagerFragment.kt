package com.example.lelangyuk.vPagerFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lelangyuk.R
import com.example.lelangyuk.databinding.FragmentViewPagerBinding
import com.example.lelangyuk.vPagerFragment.screen.HalamanKedua
import com.example.lelangyuk.vPagerFragment.screen.HalamanPertama


class ViewPagerFragment : Fragment() {
    lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedIntanceState: Bundle?
    ): View?{
        val view =inflater.inflate(R.layout.fragment_view_pager, container, false)
        binding = FragmentViewPagerBinding.bind(view)
        val fragmentList = arrayListOf(
            HalamanPertama(),
            HalamanKedua()
        )

        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)

        binding.viewPager.adapter = adapter

        return view;
    }




}